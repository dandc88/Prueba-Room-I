## Este proyecto esta basado en  el archivo de ayuda del Desafío 1 - Acceso a datos en Android

Se creó la carpeta assets para mover el archivo data.json y que se pudiera leer para transformar la información y con esto poblar la base de datos.

Se pueden leer los datos desde Room y mostrarlos en pantalla

Se puede editar el nombre de la ciudad y se muestra inmediatramente en pantalla

Tenemos una consulta que dado un id retorna: Temperatura actual,
Temperatura mínima, Temperatura máxima, Presión atmosférica, Humedad,
Velocidad del viento, Hora de salida del sol, Hora de puesta del sol:

// Consulta para obtener los datos del clima por ID
    @Query("SELECT * FROM weather WHERE id = :id")
    fun getWeatherById(id: Int): Flow<WeatherEntity?>

    se utiliza en el DetailsFragment:
    private fun getWeatherData(id: Int) ......

