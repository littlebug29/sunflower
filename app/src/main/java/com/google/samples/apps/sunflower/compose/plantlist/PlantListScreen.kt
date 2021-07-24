package com.google.samples.apps.sunflower.compose.plantlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.viewmodels.PlantListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlantListScreen(plantListViewModel: PlantListViewModel, onItemClickCallback: (Plant) -> Unit) {
    val plantList by plantListViewModel.plants.observeAsState()
    LazyVerticalGrid(
        modifier = Modifier.fillMaxHeight().padding(vertical = 26.dp),
        cells = GridCells.Fixed(2)
    ) {
        items(plantList?.size ?: 0) {
            PlantItemCard(plant = plantList?.get(it), onItemClick = onItemClickCallback)
        }
    }
}