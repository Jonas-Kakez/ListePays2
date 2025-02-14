package com.example.woof.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.woof.R
import com.example.woof.data.Country
import com.example.woof.viewModel.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryApp(navController: NavController, viewModel: CountryViewModel = viewModel()) {
    val countries by viewModel.countries.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Liste des Pays") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(countries) { country ->
                CountryItem(country)
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Log.i(
        "CountryItem",
        "Changement du pays: ${country.name.common} - Drapeau: ${country.flags.png}"
    )
    Row(modifier = Modifier.padding(8.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(country.flags.png)
                .crossfade(true)
                .error(R.drawable.error)
                .placeholder(R.drawable.load)
                .build(),
            contentDescription = "Country Flag ${country.name.common}",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = country.name.common, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Capitale: ${country.capital?.joinToString() ?: "N/A"}")
            Text(text = "Population: ${country.population}")
            Text(text = "Continent: ${country.continents.joinToString()}")
        }
    }
}
