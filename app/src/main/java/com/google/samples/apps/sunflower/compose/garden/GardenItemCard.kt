package com.google.samples.apps.sunflower.compose.garden

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.viewmodels.PlantAndGardenPlantingsViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GardenItemCard(
    viewModel: PlantAndGardenPlantingsViewModel,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier.padding(12.dp, 0.dp, 12.dp, 26.dp),
        shape = RoundedCornerShape(bottomStart = 8.dp),
        elevation = 2.dp,
        onClick = { onItemClick(viewModel.plantId) }
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.plant_item_image_height)),
                painter = rememberImagePainter(
                    data = viewModel.imageUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = stringResource(id = R.string.a11y_plant_item_image),
                contentScale = ContentScale.Crop
            )
            Text(
                text = viewModel.plantName,
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
            Text(
                text = stringResource(id = R.string.plant_date_header),
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.secondaryVariant,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
            Text(
                text = viewModel.plantDateString,
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
            Text(
                text = stringResource(id = R.string.watered_date_header),
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.secondaryVariant,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
            Text(
                text = viewModel.plantDateString,
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
            Text(
                text = LocalContext.current.resources.getQuantityString(
                    R.plurals.watering_next,
                    viewModel.wateringInterval,
                    viewModel.wateringInterval
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun previewGarden() {
}