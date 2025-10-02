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

# Capturas

> Inserta tus imágenes en la carpeta `assets/` y referencia aquí:

```markdown
![Pantalla principal](./assets/screenshot-1.png)
![Modo oscuro](./assets/screenshot-2.png)
```

# Tecnologías

* JAVA

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
git clone https://github.com/tu-usuario/Calculadora.git
cd Calculadora
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

* Pruebas manuales de UX en escritorio.

# Licencia

Proyecto bajo la licencia **MIT**. (Añade archivo `LICENSE` con texto MIT si deseas publicar.)

# Contacto

* Equipo: Giuseppe, Juliana y Tarazona
  Si quieres colaborar o reportar un bug, abre un issue en el repositorio.

---

¡Gracias por probar Calculadora! ✨
