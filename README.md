<h1 align="center"> <em>Challenge Conversor de Monedas</em> </h1>

## Índice

*[Índice](#índice)

*[Descripción del proyecto](#descripción-del-proyecto)

## Descripción
<p>Este proyecto es una aplicación en Java que utiliza la API de tasas de cambio para realizar conversiones entre diferentes monedas. La aplicación permite al usuario seleccionar diversas acciones, como convertir una cantidad de dólares estadounidenses (USD) a otra moneda específica utilizando las tasas de cambio proporcionadas por la API.</p>

## Funcionalidades Principales

<p><em>Consulta de Tasas de Cambio:</em> La aplicación realiza una solicitud a la API de tasas de cambio para obtener las últimas tasas de conversión respecto al dólar estadounidense (USD)</p>
<p><em>Interfaz de Usuario Interactiva:</em> Se proporciona una interfaz de usuario interactiva mediante la línea de comandos, donde el usuario puede seleccionar diferentes acciones a realizar.</p>
<p><em>Conversión de Monedas:</em> Permite al usuario convertir una cantidad de dólares estadounidenses a otra moneda seleccionada utilizando las tasas de cambio obtenidas de la API.</p>

## Tecnologias utilizadas

<p><em>>Java:</em> El proyecto está desarrollado en Java, aprovechando las capacidades del lenguaje para realizar solicitudes HTTP y procesar respuestas JSON.</p>
<p><em>>HttpClient:</em> Se utiliza la clase HttpClient de Java para realizar las solicitudes HTTP a la API de tasas de cambio.</p>
<p><em>JSON Parsing:</em> La biblioteca org.json.JSONObject se utiliza para analizar y manipular las respuestas JSON obtenidas de la API.</p>

## Configuración inicial

<p><em>API de Tasas de Cambio:</em> El proyecto utiliza la API de ExchangeRate-API para obtener las tasas de cambio. Es posible que necesites obtener una clave de API y configurarla en el código de la aplicación si planeas utilizarla en producción.</p>
