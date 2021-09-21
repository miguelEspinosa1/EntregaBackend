En mi caso habia podido llegar satiscactoriamente a implementar las peticiones de la API con DAO,
en el momento de usar repository tuve bastantes inconvenientes con la inyección de dependencias pero 
se pudieron resolver cuando fue necesario, actualmente lo unico que no entiendo bien en termino conceptual
y practico es el DTO , no entiendo bien su uso. Que creo yo que es la razón por la cual estoy obteniendo el 
siguiennte error : en el moemento que ejecuto un pacienteService.getAll() en postMan arroja un array vacio
(lo natural al momento de iniciar la API), en el momento en el que ejecuto un pacienteService.postPaciente()
la API trabaja y responde como si el paciente se hubiese guardado correctameente, pero , cuando trato de usar
el pacienteService.getAll() de nuevo o uso pacienteService.getById() me arroja un InternalServerError 500.
No se si el problema es relacionado al no uso de DTO y tratar de retornar un paciente directamente o si tiene 
que ver con el uso de domicilioService;  ya que odontologoController funciona correctamente en todos sus endPoints
