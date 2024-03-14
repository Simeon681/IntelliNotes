package com.example.intellinotes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.intellinotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    onSearchButtonClick: () -> Unit
) {
    val items = remember {
        mutableStateListOf(
            null as String?,
        ).apply {
            remove(null)
        }
    }

    DockedSearchBar(
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        query = query,
        placeholder = {
            Text(text = stringResource(id = R.string.search))
        },
        onQueryChange = {
            onQueryChange(it)
        },
        onSearch = {
            if (!items.contains(query)) {
                items.add(0, query)
            }

            onActiveChange(!active)
            onSearchButtonClick()
        },
        active = active,
        onActiveChange = {
            onActiveChange(it)
        },
        trailingIcon = {
            if (active) {
                IconButton(onClick = {
                    if (query.isEmpty()) {
                        onActiveChange(false)
                    } else {
                        onQueryChange("")
                    }
                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            }
        }
    ) {
        items.forEach {
            Row(modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.History,
                    contentDescription = null
                )

                Text(modifier = Modifier.weight(1f, fill = true), text = it ?: "")

                IconButton(
                    onClick = {
                        items.remove(it)
                    }
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                }
            }
        }
    }
}