let datosActuales = null;
let estadoActual = "";

function simularAnalisis() {
  return {
    frecuenciaCardiaca: Math.floor(Math.random() * (100 - 60 + 1)) + 60,
    saturacionOxigeno: Math.floor(Math.random() * (100 - 95 + 1)) + 95,
    pasos: Math.floor(Math.random() * (12000 - 5000 + 1)) + 5000,
    calorias: Math.floor(Math.random() * (700 - 300 + 1)) + 300
  };
}

function evaluarEstado({frecuenciaCardiaca, saturacionOxigeno}) {
  if (frecuenciaCardiaca < 60 || frecuenciaCardiaca > 100 || saturacionOxigeno < 95)
    return "Alerta: signos vitales anormales";
  if (frecuenciaCardiaca < 65 || frecuenciaCardiaca > 95 || saturacionOxigeno < 97)
    return "Precaución: revise sus signos vitales";
  return "Signos vitales normales";
}

function mostrarAnalisis(datos) {
  document.getElementById('fc').textContent = datos.frecuenciaCardiaca + " lpm";
  document.getElementById('so').textContent = datos.saturacionOxigeno + "%";
  document.getElementById('pasos').textContent = datos.pasos.toLocaleString();
  document.getElementById('calorias').textContent = datos.calorias + " kcal";
}

function mostrarEstado(estado) {
  const estadoDiv = document.getElementById('estadoAnalisis');
  estadoDiv.textContent = estado;
  if (estado.startsWith("Alerta")) {
    estadoDiv.style.color = "#e53935";
  } else if (estado.startsWith("Precaución")) {
    estadoDiv.style.color = "#fbc02d";
  } else {
    estadoDiv.style.color = "#43a047";
  }
}

async function guardarAnalisis() {
  const usuarioStr = localStorage.getItem('usuario');
  if (!usuarioStr || !datosActuales) {
    alert('No hay usuario autenticado o datos de análisis.');
    return;
  }
  const usuario = JSON.parse(usuarioStr);
  const payload = {
    usuarioId: usuario.id,
    frecuenciaCardiaca: datosActuales.frecuenciaCardiaca,
    saturacionOxigeno: datosActuales.saturacionOxigeno,
    pasos: datosActuales.pasos,
    calorias: datosActuales.calorias,
    estado: estadoActual
  };
  try {
    const resp = await fetch('http://localhost:8080/api/analisis', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(payload)
    });
    if (resp.ok) {
      alert('Análisis guardado correctamente');
    } else {
      alert('Error al guardar el análisis');
    }
  } catch (error) {
    alert('Error al guardar el análisis');
  }
}

function nuevoAnalisis() {
  datosActuales = simularAnalisis();
  estadoActual = evaluarEstado(datosActuales);
  mostrarAnalisis(datosActuales);
  mostrarEstado(estadoActual);
}

document.addEventListener('DOMContentLoaded', () => {
  // Mostrar datos usuario
  const usuarioStr = localStorage.getItem('usuario');
  if (usuarioStr) {
    const usuario = JSON.parse(usuarioStr);
    document.getElementById('userName').textContent = usuario.nombre;
    document.getElementById('userEmail').textContent = usuario.correo;
  }
  // Inicializa con un análisis simulado
  nuevoAnalisis();
  document.getElementById('btnNuevo').addEventListener('click', nuevoAnalisis);
  document.getElementById('btnGuardar').addEventListener('click', guardarAnalisis);
});
