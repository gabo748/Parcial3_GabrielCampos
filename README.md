# Android GabCam (Parcial Gabriel Campos)

## Descripción General
Esta aplicación de Android permite a los usuarios capturar fotos, grabar videos y visualizar el contenido almacenado en su galería. La interfaz se ha diseñado para ofrecer una experiencia atractiva e intuitiva, utilizando **Jetpack Compose** para construir una UI moderna y con animaciones fluidas. A través de un proceso de **OnBoarding**, el usuario recibe una introducción a las funciones de la app, y en la pantalla de inicio puede seleccionar rápidamente entre ver fotos y videos, tomar fotos o grabar videos.

## Bibliotecas Utilizadas
- **Jetpack Compose**: Para crear la interfaz de usuario declarativa.
- **AndroidX Navigation**: Gestión de la navegación en la aplicación.
- **Material 3**: Para componentes de UI estandarizados y estilizados.
- **Android CameraX**: Integración con la cámara para capturar fotos y videos de manera sencilla y eficiente.

## Estructura de la App

### Navegación (`AppNavigation.kt`)
La navegación de la aplicación utiliza **AndroidX Navigation** y se define mediante `NavHost`. La navegación incluye las siguientes pantallas:
- `OnBoardingScreen`: Pantalla de introducción que explica la funcionalidad de la app.
- `HomeScreen`: Pantalla principal con opciones de captura de foto, video y visualización de galería.
- `PhotoScreen`: Pantalla para capturar fotos.
- `VideoScreen`: Pantalla para grabar videos.
- `GalleryScreen`: Pantalla para abrir la galería (usando Intents).

### Pantalla de OnBoarding (`OnBoardingScreen.kt`)
Esta pantalla ofrece una introducción visual a la aplicación mediante una serie de "slides" con tarjetas explicativas.

#### Funciones Clave
- `OnBoardingScreen`: Maneja el carrusel de OnBoarding, permitiendo avanzar o retroceder por las páginas.
- `OnBoardingPageContent`: Diseña el contenido de cada página de OnBoarding, utilizando un fondo redondeado, íconos grandes y una descripción.

#### Decisiones de Diseño
- Cada página de OnBoarding se presenta en una tarjeta con bordes redondeados, un ícono destacado y texto explicativo.
- Los botones "Anterior" y "Siguiente/Empezar" están centrados en la parte inferior para una navegación fluida y fácil acceso.

### Pantalla de Inicio (`HomeScreen.kt`)


https://github.com/user-attachments/assets/1b56f6f5-b080-40d7-b42d-804e40ed9017



#### Funciones Clave
- `HomeScreen`: Contiene tres tarjetas (`HomeScreenCard`) que representan las funcionalidades clave de la app.
- `HomeScreenCard`: Un componente reutilizable que muestra un ícono, título y descripción dentro de una tarjeta con sombra y bordes redondeados.

#### Decisiones de Diseño
- Las tarjetas en `HomeScreen` usan colores fuertes y un ícono prominente para que las funcionalidades sean visualmente identificables.
- Cada tarjeta tiene bordes redondeados y un fondo con sombra para una experiencia visual más agradable.

### Pantalla de Captura de Fotos (`PhotoScreen.kt`)
La pantalla `PhotoScreen` utiliza **CameraX** para tomar fotos y almacenarlas en la galería del dispositivo.

#### Funciones Clave
- `PhotoScreen`: Inicializa la cámara y permite al usuario capturar fotos.
- `PhotoControls`: Controles de la cámara (captura de foto, cambio de cámara y activación de flash).
- `CameraViewModel`: Administra la lógica para almacenar fotos en la galería y manejar el estado de la cámara.

#### Decisiones de Diseño
- Se utilizó **CameraX** por su facilidad de uso y capacidades avanzadas.
- Los controles están alineados en la parte inferior, con íconos intuitivos y opciones para alternar la cámara y el flash.

### Pantalla de Grabación de Video (`VideoScreen.kt`)
La pantalla `VideoScreen` permite la grabación de videos y almacenamiento en la galería.

#### Funciones Clave
- `VideoScreen`: Administra la configuración de **CameraX** para grabar videos, ofreciendo opciones de inicio y parada de grabación.
- `VideoControls`: Controles de grabación de video, incluyendo opciones para cambiar de cámara y activar el flash.
- `CameraViewModel`: Almacena los videos en la galería y gestiona la lógica del video.

#### Decisiones de Diseño
- Los controles de grabación están alineados en la parte inferior de la pantalla para fácil acceso.
- Los botones cambian de color y de ícono para indicar visualmente el estado de grabación (grabando o detenido).

### Pantalla de Galería (`GalleryScreen.kt`)
Permite al usuario abrir la galería del dispositivo para ver sus fotos y videos.

#### Funciones Clave
- `onOpenPhotoGallery`: Utiliza un **Intent** para abrir la galería y filtrar el contenido por fotos o videos.

#### Decisiones de Diseño
- La galería se abre mediante `Intent` para maximizar la compatibilidad con dispositivos Android y evitar la necesidad de implementar un visor de imágenes y videos personalizado.

## Detalles de Estilo y Diseño
1. **Tarjetas con Bordes Redondeados y Sombras**: En `HomeScreen` y `OnBoardingScreen`, se utilizan tarjetas con esquinas redondeadas y sombras ligeras para un aspecto más moderno y agradable.
2. **Íconos Prominentes**: Cada funcionalidad tiene un ícono representativo y descriptivo.
3. **Colores Fuertes y Contrastes**: Los colores de las tarjetas en `HomeScreen` son fuertes para destacar la funcionalidad y mejorar la experiencia visual.
4. **Botones Intuitivos**: Los botones están diseñados con una paleta de colores llamativa y tienen etiquetas descriptivas.

## Resumen
Esta aplicación utiliza **Jetpack Compose** y **CameraX** para ofrecer una experiencia de usuario intuitiva y atractiva. Las decisiones de diseño priorizan la claridad y la facilidad de uso, con un enfoque en una interfaz visualmente atractiva y componentes reutilizables. Los usuarios pueden navegar fácilmente por las funciones de la app y capturar o visualizar sus momentos especiales sin dificultad.
