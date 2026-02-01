# RPG Loot Forge

Offline Android app for checking D&D-style loot tables by player level, plus quick vendor stock lists for improvisation based on level, availability chance, and discounts.

## Screenshots
<img width="202" height="450" alt="Screenshot_20260201_171153" src="https://github.com/user-attachments/assets/3a3d69ba-0f00-4cad-8e28-7e0c6d6d60be" />
<img width="202" height="450" alt="Screenshot_20260201_171353" src="https://github.com/user-attachments/assets/b5b7f3cc-42b3-4e27-9669-c4b560cb492c" />
<img width="202" height="450" alt="Screenshot_20260201_171510" src="https://github.com/user-attachments/assets/4e281430-21b2-4b3c-b5e0-cf051c720074" />
<img width="202" height="450" alt="Screenshot_20260201_171307" src="https://github.com/user-attachments/assets/d46c75e6-cbdd-4d18-acfe-3711b267caf0" />

## Features
- Browse loot tables (A–I) based on player level
- Generate quick vendor inventories for sessions
- Vendor modifiers:
  - availability chance (probability an item appears)
  - discount modifier (positive/negative)
- Fully offline (no server required)

## How it works
- Loot tables are selected based on the player's level.
- Vendor lists are generated using the player's level and vendor modifiers (availability + discount), to help improvise shop inventories quickly during a session.

## Tech stack
- Kotlin
- Jetpack Compose
- MVVM
- Hilt
- Coroutines + Flow (StateFlow)

## Getting started
1. Clone the repo
2. Open in Android Studio
3. Run the `app` configuration on an emulator/device

## Roadmap
- Better filtering/search across items
- More vendor presets
- UI polish / tablet layout

## License
MIT
