package com.google.samples.apps.sunflower.compose.garden

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings
import com.google.samples.apps.sunflower.viewmodels.GardenPlantingListViewModel
import com.google.samples.apps.sunflower.viewmodels.PlantAndGardenPlantingsViewModel

@Composable
fun GardenListScreen(
    viewModel: GardenPlantingListViewModel,
    onItemClickListener: (String) -> Unit,
    onAddPlantButtonClick: () -> Unit
) {
    val plantingList by viewModel.plantAndGardenPlantings.observeAsState()
    if (plantingList.isNullOrEmpty()) {
        EmptyGarden(onAddPlantButtonClick)
    } else {
        GardenList(
            gardenPlantingList = plantingList!!,
            onItemClickListener = onItemClickListener
        )
    }
}

@Composable
fun EmptyGarden(
    onAddPlantButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.wrapContentWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.garden_empty),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp,
            style = MaterialTheme.typography.h5
        )
        Button(
            onClick = onAddPlantButtonClick,
            modifier = Modifier.padding(top = 8.dp),
            elevation = ButtonDefaults.elevation(2.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colors.primary,
                backgroundColor = MaterialTheme.colors.onPrimary
            ),
            shape = RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp)
        ) {
            Text(
                text = AnnotatedString(text = stringResource(id = R.string.add_plant)).toUpperCase(),
            )
        }
    }
}

@Preview
@Composable
fun PreviewEmptyGarden() {
    EmptyGarden {

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GardenList(
    gardenPlantingList: List<PlantAndGardenPlantings>,
    onItemClickListener: (String) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 26.dp),
        cells = GridCells.Fixed(2)
    ) {
        items(gardenPlantingList.size) {
            GardenItemCard(
                viewModel = PlantAndGardenPlantingsViewModel(gardenPlantingList[it]),
                onItemClick = onItemClickListener
            )
        }
    }
}