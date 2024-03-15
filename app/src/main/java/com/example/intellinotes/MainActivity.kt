package com.example.intellinotes

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toFile
import androidx.navigation.compose.rememberNavController
import com.example.intellinotes.navigation.AppNavHost
import java.io.File

class MainActivity : ComponentActivity() {

    private val REQUEST_CODE_STORAGE_PERMISSION = 100
    private var file: File? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                AppNavHost(
                    navController = rememberNavController(),
                    onTextSelect = { selectText() }
                )
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_CODE_STORAGE_PERMISSION
                )
            } else {
                accessUserFiles()
            }
        } else {
            accessUserFiles()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, access files here
                accessUserFiles()
            } else {
                Toast.makeText(
                    this,
                    "Permission Denied!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun accessUserFiles() {
        val externalDir = Environment.getExternalStorageDirectory()
        val files = externalDir.listFiles()
        files?.forEach { file ->
            // Process each file
            println("File: ${file.name}")
        }
    }

    private val selectMp3FileLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                // Check if the selected file has a valid MP3 MIME type
                if (isMp3File(uri)) {
                    file = uri.toFile()
                } else {
                    // Notify the user that only MP3 files are allowed
                    Toast.makeText(this, "Please select an MP3 file.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isMp3File(uri: Uri): Boolean {
        contentResolver.getType(uri)?.let { mimeType ->
            return mimeType == "audio/mpeg" || mimeType == "audio/mp3"
        }
        return false
    }

    private fun selectVoice() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "audio/*"
            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("audio/mpeg", "audio/mp3"))
        }

        selectMp3FileLauncher.launch(intent)
    }

    private fun isTextFile(uri: Uri): Boolean {
        contentResolver.getType(uri)?.let { mimeType ->
            return mimeType == "text/*"
        }
        return false
    }

    private val selectTextFileLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                // Check if the selected file has a valid text MIME type
                if (isTextFile(uri)) {
                    file = uri.toFile()
                } else {
                    // Notify the user that only text files are allowed
                    Toast.makeText(this, "Please select a text file.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun selectText() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "text/*"
        }

        selectTextFileLauncher.launch(intent)
    }
}