package com.example.a211368_nelson_project1.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.a211368_nelson_project1.viewmodel.LabViewModel

// data model
data class ExperimentDetail(
    val title: String,
    val description: String,
    val objective: String,
    val materials: String,
    val steps: String
)

// data source
fun getExperimentDetail(name: String): ExperimentDetail {
    return when (name) {

        "Acid Reaction" -> ExperimentDetail(
            title = "Acid Reaction",
            description = "Study how acids react with metals.",
            objective = "To observe hydrogen gas formation when acid reacts with metal.",
            materials = "Zinc, Hydrochloric Acid, Test Tube",
            steps = "1. Add zinc into test tube\n2. Pour acid\n3. Observe bubbles"
        )

        "Acid-Base Titration" -> ExperimentDetail(
            title = "Acid-Base Titration",
            description = "Determine concentration using neutralization.",
            objective = "To determine unknown concentration using titration.",
            materials = "Burette, Indicator, Acid, Base",
            steps = "1. Fill burette\n2. Add indicator\n3. Titrate until color change"
        )

        "Electrolysis" -> ExperimentDetail(
            title = "Electrolysis",
            description = "Break compounds using electricity.",
            objective = "To observe decomposition using electrical energy.",
            materials = "Battery, Electrodes, Electrolyte",
            steps = "1. Setup circuit\n2. Insert electrodes\n3. Observe reaction"
        )

        "Pendulum Motion" -> ExperimentDetail(
            title = "Pendulum Motion",
            description = "Investigate oscillation.",
            objective = "To study relationship between length and period.",
            materials = "String, Weight, Stopwatch",
            steps = "1. Setup pendulum\n2. Measure swings\n3. Record time"
        )

        else -> ExperimentDetail(
            title = name,
            description = "No description available",
            objective = "-",
            materials = "-",
            steps = "-"
        )
    }
}

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: LabViewModel,
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {

    val detail = getExperimentDetail(viewModel.userData.experiment)

    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
            MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.25f),
            MaterialTheme.colorScheme.surface
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgGradient)
            .padding(20.dp)
    ) {

        // HEADER
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .clip(RoundedCornerShape(14.dp))
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    "Experiment Detail",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    detail.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // MAIN CARD
        Card(
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(modifier = Modifier.padding(20.dp)) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.School,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        detail.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                @Composable
                fun Section(title: String, content: String) {
                    Column(modifier = Modifier.padding(bottom = 12.dp)) {

                        Text(
                            title,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            content,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Section("Objective", detail.objective)
                Section("Materials", detail.materials)
                Section("Steps", detail.steps)

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = onNext,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Continue", fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // TIPS CARD
        Card(
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(modifier = Modifier.padding(16.dp)) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        Icons.Default.Description,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        "Tips",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "• Be clear and concise\n• Include observations\n• Write conclusion based on results",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}