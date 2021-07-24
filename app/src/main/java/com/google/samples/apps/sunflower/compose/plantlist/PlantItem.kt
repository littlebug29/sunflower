package com.google.samples.apps.sunflower.compose.plantlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.data.Plant

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlantItemCard(plant: Plant?, onItemClick: (Plant) -> Unit) {
    plant?.let {
        Card(
            modifier = Modifier.padding(12.dp, 0.dp, 12.dp, 26.dp),
            shape = RoundedCornerShape(bottomStart = 8.dp),
            elevation = 2.dp,
            onClick = { onItemClick(it) }
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .height(95.dp)
                        .fillMaxWidth(),
                    painter = rememberImagePainter(
                        data = it.imageUrl,
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(id = R.string.a11y_plant_item_image)
                )
                Text(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = it.name,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun previewItemCard() {
    PlantItemCard(plant = Plant("id", "Flower", "A flower", 1), onItemClick = {})
}
