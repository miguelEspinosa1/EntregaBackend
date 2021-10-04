Recomendaciones al momento de usar la api:

Implementé los conceptos básicos de cada uno de los temas, tuve uno que otro inconveniente que fui
resolviendo muy poco ortodoxamente.
Con respecto al uso de las fechas,no encontre la manera de pasar una fecha en formato JSON, lo que
dicidí hacer fue requerir en el constructor de turno un String como fecha y  un string como hora ,
el formato de fecha es YYYY-MM-DD, formato de hora HH:MM:SS.
En pacientes al momento de crearlo se coloca automaticamente la fecha actual en formato YYYY-MM-DD, cuando
se quiera actualizar se puede enviar como String en el JSON.
Al momento de crear un turno se valida si el doctor esta ocupado a esa hora, esto significa que si se
ordena un turno a las 06:30:00, el doctor estará ocupado de 06:00:00 a 06:59:59, es recomendable agendar los
turnos a cada hora en punto, el paciente puede crear cuantos turnos sean necesarios a la misma hora.
No pude insertar directamente un nuevo usuario ADMIN-padre en el programa de h2, asi que decidi hardcodearlo
en el AppUserService usando ApplicationRunner, para validar el usuario, el programa exigirá email (que en este
caso es "mateo@paez.com") y una password (que en este caso es "password").
No aprendí a agregar la información de validación por medio de postman, asi que en los request que estan agregados
en la info es necesario agregar dicha información de validacion.