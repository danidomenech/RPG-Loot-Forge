# RPG Loot Forge

An offline Android application designed to help Dungeon Masters manage D&D-style magic items, generate loot tables, and create randomized vendor inventories during tabletop RPG sessions.

Built with Kotlin, Jetpack Compose, MVVM, Hilt, and Clean Architecture principles, with an emphasis on maintainability, separation of concerns, and modern Android development practices.

## Screenshots
<img width="202" height="450" alt="Screenshot_20260201_171153" src="https://github.com/user-attachments/assets/3a3d69ba-0f00-4cad-8e28-7e0c6d6d60be" />
<img width="202" height="450" alt="Screenshot_20260201_171353" src="https://github.com/user-attachments/assets/b5b7f3cc-42b3-4e27-9669-c4b560cb492c" />
<img width="202" height="450" alt="Screenshot_20260201_171510" src="https://github.com/user-attachments/assets/4e281430-21b2-4b3c-b5e0-cf051c720074" />
<img width="202" height="450" alt="Screenshot_20260201_171307" src="https://github.com/user-attachments/assets/d46c75e6-cbdd-4d18-acfe-3711b267caf0" />

## Features
- Item collection: Browse magic items with details such as rarity, type, description, and value.
- Loot tables: Explore weighted loot tables (A–I) based on item power level and recommended player level.
- Narrative loot: Browse special items intended for narrative encounters and rewards.
- Vendor inventory: Browse items available to vendors based on player level.
- Vendor catalog generation: Generate randomized inventories with configurable stock availability and price modifiers.
- Offline operation: All item data is available locally without requiring a server or internet connection.

## Architecture

The application follows a single-Activity, Compose-first architecture with MVVM and separation into presentation, domain, and data layers.

### Presentation layer

Features follow a Route/Screen pattern:

- Route: Collects UI state and coordinates navigation and presentation-level effects.
- Screen: Renders UI state and exposes user interactions through actions, without directly depending on ViewModels or navigation controllers.
- ViewModel: Manages screen state, processes state-related actions, and coordinates domain use cases.
- UiState: Represents the data required to render a screen.
- Action: Represents user interactions originating from the UI.
  
Simple navigation actions are handled directly by Routes. When navigation or another one-shot effect depends on ViewModel processing, the ViewModel can emit an event for the Route to handle.

This keeps navigation outside ViewModels without requiring an event pipeline for every interaction.

### Domain layer

Contains domain models, reusable business rules, repository interfaces, and use cases responsible for operations such as:

- Retrieving and organizing items
- Generating weighted loot tables
- Selecting vendor-eligible items by player level
- Generating randomized vendor catalogs

### Data layer

Provides local item catalogs, data sources, repository implementations, and mappings to domain models.

The project is intentionally kept in a single Gradle module, while maintaining logical separation between its architectural layers.

### Navigation

The application uses Jetpack Navigation Compose with NavHost, centralized destinations, and navigation arguments.

Feature screens remain independent of navigation implementation details.

## Tech Stack

- Kotlin
- Jetpack Compose and Material 3
- Navigation Compose (NavHost)
- MVVM
- Hilt dependency injection
- Kotlin Coroutines and StateFlow
- Android string resources and Compose previews
- Getting Started
- Clone the repository.
- Open the project in Android Studio.
- Sync the Gradle project.
- Run the app configuration on an emulator or Android device.

No server configuration or API keys are required.

## Roadmap

- Advanced item filtering and search
- Additional vendor presets
- UI polish and improved tablet layouts
- Unit tests for domain use cases

## License
MIT
