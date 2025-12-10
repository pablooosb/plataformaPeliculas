<h1 align="center">Actor</h1>

`http://localhost:8080/actores/add` → Nos permite añadir un actor mediante una petición POST, recibiendo en la petición un DTO con los datos del actor que queremos introducir en formato JSON y al llamar al servicio, éste lo guarda en la BBDD

`http://localhost:8080/actores` → Nos muestra todos los actores que tenemos almacenados en la BBDD llamando al servicio mediante una petición GET, que es quien nos muestra la lista de actores

`http://localhost:8080/actores/{id}` → Nos permite buscar un actor según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar un actor con el id pedido

`http://localhost:8080/actores/update` → Nos permite actualizar el actor deseado mediante una petición POST. Para actualizarlo tenemos que enviar la URL y un JSON con los datos actualizados del actor y el mapper lo convierte en una entidad Actor, para que al recibirlo el servicio actualice la BBDD

`http://localhost:8080/actores/delete/{id}` → Nos permite eliminar un actor en concreto usando una petición DELETE, mediante su id, llamando al servicio que es quien se encarga de eliminarlo

`http://localhost:8080/actores/activos` → Nos muestra los actores que están actualmente en activo mediante una petición GET, la cual llama al servicio para que filtre los actores, devolviendo una lista con los actores

<h1 align="center">Director</h1>

`http://localhost:8080/directores/add` → Nos permite añadir un director mediante una petición POST, recibiendo en la petición un DTO con los datos del director que queremos introducir en formato JSON y al llamar al servicio, éste lo guarda en la BBDD

`http://localhost:8080/directores` → Nos muestra todos los directores que tenemos almacenados en la BBDD llamando al servicio mediante una petición GET, que es quien nos muestra la lista de directores

`http://localhost:8080/directores/{id}` → Nos permite buscar un director según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar un director con el id pedido

`http://localhost:8080/directores/update` → Nos permite actualizar el director deseado mediante una petición POST. Para actualizarlo tenemos que enviar la URL y un JSON con los datos actualizados del directory el mapper lo convierte en una entidad Director, para que al recibirlo el servicio actualice la BBDD

`http://localhost:8080/directores/delete/{id}` → Nos permite eliminar un director en concreto usando una petición DELETE, mediante su id, llamando al servicio que es quien se encarga de eliminarlo

`http://localhost:8080/directores/mayoresA70` → Nos muestra los directores que tienen más de 70 años mediante una petición GET, llamando al servicio para que los filtre y devuelva en una lista solo los que cumplan el requisito

<h1 align="center">Pelicula</h1>
  
`http://localhost:8080/peliculas/add` → Nos permite añadir una película mediante una petición POST, recibiendo en la petición un DTO con los datos de la película que queremos introducir en formato JSON y al llamar al servicio, éste la guarda en la BBDD

`http://localhost:8080/peliculas` → Nos muestra todas las películas que tenemos almacenados en la BBDD llamando al servicio mediante una petición GET, que es quien nos muestra la lista de películas

`http://localhost:8080/peliculas/{id}` → Nos permite buscar una película según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar una película con el id pedido

`http://localhost:8080/peliculas/update` → Nos permite actualizar la película deseada mediante una petición POST. Para actualizarla tenemos que enviar la URL y un JSON con los datos actualizados de la película y el mapper la convierte en una entidad Pelicula, para que al recibirla el servicio actualice la BBDD

`http://localhost:8080/peliculas/delete/{id}` → Nos permite buscar una película según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar una película con el id pedido

`http://localhost:8080/peliculas/aptas12` → Nos muestra las películas que puede ver un niño de 12 años, es decir, PEGI 3, PEGI 7 Y PEGI 12. Y para esto usando una petición GET que llama al servicio para filtrar las películas y devolver la lista de las que cumplen los requisitos

<h1 align="center">Plataforma_streaming</h1>

`http://localhost:8080/plataformasStreaming/add` → Nos permite añadir una plataforma de streaming mediante una petición POST, recibiendo en la petición un DTO con los datos de la plataforma de streaming que queremos introducir en formato JSON y al llamar al servicio, éste la guarda en la BBDD

`http://localhost:8080/plataformasStreaming` → Nos muestra todas las plataforma de streaming que tenemos almacenados en la BBDD llamando al servicio mediante una petición GET, que es quien nos muestra la lista de plataformas de streaming

`http://localhost:8080/plataformasStreaming/{id}` → Nos permite buscar una plataforma de streaming según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar una plataforma de streaming con el id pedido

`http://localhost:8080/plataformasStreaming/update` → Nos permite actualizar la plataforma de streaming deseada mediante una petición POST. Para actualizarla tenemos que enviar la URL y un JSON con los datos actualizados de la plataforma de streaming y el mapper la convierte en una entidad Plataforma_streaming, para que al recibirla el servicio actualice la BBDD

`http://localhost:8080/plataformasStreaming/delete/{id}` → Nos permite buscar una plataforma de streaming según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar una plataforma de streaming con el id pedido

`http://localhost:8080/plataformasStreaming/count` → Nos muestra los países y el número de plataformas de streaming que tenemos de cada uno, y llama al servicio para que localice y muestre una lista con los paises y el numero de plataformas de streaming que tiene cada uno

<h1 align="center">Pelicula_plataforma</h1>

`http://localhost:8080/peliculasPlataformas/add` → Nos permite añadir una pelicula plataforma mediante una petición POST, recibiendo en la petición un DTO con los datos de la pelicula plataforma que queremos introducir en formato JSON y al llamar al servicio, éste la guarda en la BBDD

`http://localhost:8080/peliculasPlataformas` → Nos muestra todas las peliculas plataformas de streaming que tenemos almacenados en la BBDD llamando al servicio mediante una petición GET, que es quien nos muestra la lista de peliculas plataformas

`http://localhost:8080/peliculasPlataformas/{id}` → Nos permite buscar una pelicula plataforma según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar una pelicula plataforma con el id pedido

`http://localhost:8080/peliculasPlataformas/update` → Nos permite actualizar la pelicula plataforma deseada mediante una petición POST. Para actualizarla tenemos que enviar la URL y un JSON con los datos actualizados de la pelicula plataforma y el mapper la convierte en una entidad Pelicula_plataforma, para que al recibirla el servicio actualice la BBDD

`http://localhost:8080/peliculasPlataformas/delete/{id}` → Nos permite buscar una pelicula plataforma según su id mediante una petición GET, llamando a la BBDD con el servicio para buscar una pelicula plataforma con el id pedido

`http://localhost:8080/peliculasPlataformas/peliculasBaratas` → Nos muestra las peliculas plataformas mediante una petición GET la cual llama al servicio para que filtre las peliculas plataformas y que nos muestre la lista de los resultados

`http://localhost:8080/peliculasPlataformas/count` → Nos muestra las plataformas de streaming y el número de películas que tiene cada una, y llama al servicio para que localice y muestre una lista con las plataformas de streaming y el número de películas que tiene cada una
