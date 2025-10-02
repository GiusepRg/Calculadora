# 🧮 Calculadora Pro — Proyecto Final

> Una calculadora limpia, accesible y elegante, creada como proyecto educativo.
> Hecha con cariño por Giuseppe, Juliana y Tarazona.

---

![calculadora-banner](/assets/banner.svg/)

# Descripció n

Calculadora Pro es una aplicación simple y bonita para realizar operaciones aritméticas básicas y algunas funciones avanzadas (por ejemplo: porcentaje, raíz cuadrada y memoria). Ideal para usar en el navegador o como punto de partida para agregar más funciones.

# Características principales

* Operaciones básicas: `+`, `-`, `×`, `÷`.
* Soporte de punto decimal y manejo correcto de precedencia (si aplica).
* Funciones extra: `%`, `√`, `+/-` (cambiar signo), `M+`, `M-`, `MC`, `MR`.
* Interfaz responsiva (móvil y desktop).
* Accesible vía teclado (atajos numéricos y Enter para =).
* Diseño moderno y limpio con animaciones sutiles.

# Demo

Puedes ver una demo en: `https://tu-dominio-ejemplo.com` *(reemplaza con tu URL de despliegue cuando esté disponible)*

# Capturas

> Inserta tus imágenes en la carpeta `assets/` y referencia aquí:

```markdown
![Pantalla principal](./assets/screenshot-1.png)
![Modo oscuro](./assets/screenshot-2.png)
```

# Tecnologías

* HTML5
* CSS3 (Flexbox / Grid)
* JavaScript (ES6+)
* Opcional: SASS / Webpack / Vite para builds

# Estructura del proyecto

```
calculadora-pro/
├─ assets/
│  ├─ banner.png
│  └─ screenshot-1.png
├─ src/
│  ├─ index.html
│  ├─ styles.css
│  └─ app.js
├─ README.md
└─ LICENSE
```

# Instalación (rápida)

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/calculadora-pro.git
cd calculadora-pro
```

2. Abre `src/index.html` en tu navegador, o sirve el proyecto con un servidor local:

```bash
# si tienes Python 3
python -m http.server 5500
# luego abre http://localhost:5500/src
```

# Uso

* Haz clic en los botones o usa el teclado:

  * Números: `0–9`
  * Punto decimal: `.`
  * Operaciones: `+ - * /`
  * Igual: `Enter` o `=`
  * Borrar: `Esc` o `C` (según la implementación)
* Ejemplo:

  1. Escribe `12`
  2. Presiona `+`
  3. Escribe `7.5`
  4. Presiona `Enter` → Resultado `19.5`

# Atajos de teclado sugeridos

* `Enter` → `=`
* `Backspace` → borrar último dígito
* `Esc` → limpiar todo
* `M` → abrir opciones de memoria (o usar botones dedicados)

# Buenas prácticas implementadas

* Manejo de errores (división por cero, entradas inválidas).
* Input sanitizado antes de evaluar operaciones.
* Animaciones y foco visible para accesibilidad.

# Cómo contribuir

¡Bienvenidos los PRs! Sugerencias:

1. Forkea el repositorio.
2. Crea una rama con tu mejora: `git checkout -b feat/nombre-mejora`
3. Haz commits claros y descriptivos.
4. Abre un Pull Request describiendo los cambios.

# Roles del equipo

* **Giuseppe** — Frontend / Diseño UI
* **Juliana** — Lógica de operaciones / Validaciones
* **Tarazona** — Integración, pruebas y despliegue

# Pruebas

* Se recomienda añadir tests unitarios (p. ej. con Jest para la lógica JS).
* Pruebas manuales de UX en móvil y escritorio.

# Despliegue

* Opciones rápidas: GitHub Pages, Netlify o Vercel.
* Pasos generales:

  1. Subir a un repo público.
  2. Conectar el repo a Netlify / Vercel o habilitar Pages en GitHub.
  3. Publicar.

# Licencia

Proyecto bajo la licencia **MIT**. (Añade archivo `LICENSE` con texto MIT si deseas publicar.)

# Contacto

* Equipo: Giuseppe, Juliana y Tarazona
  Si quieres colaborar o reportar un bug, abre un issue en el repositorio.

---

¡Gracias por probar Calculadora Pro! ✨
Si quieres, te hago una versión del README adaptada a un lenguaje (React, Python, Java) o con secciones traducidas al inglés. ¿Deseas eso?
