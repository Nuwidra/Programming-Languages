% ----------------------------------------------------------------------
%                                          TAREA PROGRAMADA III - Prolog
% ----------------------------------------------------------------------
% JONATHAN QUESADA SALAS      - 2020023583
% PABLO ALBERTO MUÑOZ HIDALGO - 2020031899
% ----------------------------------------------------------------------

% ----------------------------------------------------------------------
%        EL MENÚ INICIAL PARA INGRESAR EL NOMBRE DEL PACIENTE PARA LUEGO
% ESTABLECER EL PACIENTE JUNTO CON LA ENFERMEDAD QUE SE HAYA ESTABLECIDO
% ----------------------------------------------------------------------
programa :-
    write('--------------------------------------------------'),nl,
    write('                   Consultorio del Puvlo y Nuwidra'),nl,
    write('--------------------------------------------------'),nl,
    write('Ingrese su nombre para realizarle un diagnostico'),nl,
    write('--------------------------------------------------'),nl,
    write('El nombre del paciente es: '),nl,
    write('--------------------------------------------------'),nl,
    read(Paciente),
    write('--------------------------------------------------'),nl,
    write('Debe de elegir sus padecimientos para recibir un diagnostico: '),nl,
    write('--------------------------------------------------'),nl,
    posible_enfermedad_padecible(Paciente,Padecimiento),nl,
    write('--------------------------------------------------'),nl,
    arreglo_escribir_lista(['El diagnostico seria que tienes ',Padecimiento,'.']),nl,
    write('--------------------------------------------------'),nl,
    write('Si quieres una recomendacion para ciertos padecimientos responda lo siguiente: '),nl,
    write('--------------------------------------------------'),nl,
    recomendacion_posible_enfermedad_padecible(Paciente,Recomendacion),nl,
    write('--------------------------------------------------'),nl,
    arreglo_escribir_lista(['La recomendacion seria ',Recomendacion,'.']).

programa :-
    % -------------------------------------------------------------------------------------------
    % SI NO SE ENCUENTRA ALGUNA ENFERMEDAD O PADECIMIENTO ASOCIADO SE RETORNA EL SIGUIETE MENSAJE
    % -------------------------------------------------------------------------------------------
    write('No se pudo diagnosticar y recomendar correctamente los sintomas').

% -----------------------------------------------------------------------
% LA FUNCIÓN RECURSIVA QUE SE ESTABLECE EN LA ESPECIFICACIÓN
% -----------------------------------------------------------------------
% ARREGLO_ESCRIBIR_LISTA: LA FUNCIONALIDAD DE ESTA FUNCIONALIDAD ES
% PODER ESCRIBIR CARACTER POR CARACTER UNA HILERA COMPLETA CON
% CARACTERES EXTRAYENDO LA CABEZA Y RECORRER LA COLA PARA LUEGO EXTRAER
% LA CABEZA DE ESA MISMA COLA
% -----------------------------------------------------------------------
arreglo_escribir_lista([]).
arreglo_escribir_lista([Cabeza| Cola]) :-
    write(Cabeza),
    arreglo_escribir_lista(Cola).

% ----------------------------------------------------------------------
%                           SE ALMACENA LA RESPUESTA DADA POR EL USUARIO
% ----------------------------------------------------------------------
respuesta(Opcion) :-
    % Obtenga un solo carácter de la secuencia de entrada 'usuario' (independientemente de la secuencia de entrada actual).
    get_single_char(Code),
    % Es un número entero no negativo. Tenga en cuenta que esto puede generar una excepción si la codificación del flujo de salida no puede representar el código
    put_code(Code), nl,
    % Convierta entre un solo carácter (un átomo de longitud 1) y su código de carácter (un número entero que denota el carácter correspondiente).
    char_code(Opcion, Code).


% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE ARDOR AL ORINAR
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,ardor_orinar) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene dolor o ardor al orinar? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE ARDOR AL ORINAR
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,ardor_orinar) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene dolor o ardor al orinar? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE FIEBRE
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,fiebre) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene fiebre? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE DOLOR EN EL COITO
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,dolor_coito) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene dolor en el coito? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE LLAGAS EN LOS GENITALES
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,llagas_genitales) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene llagas en los genitales? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE TOS
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,tos) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene voz seca? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE CANSANCIO
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,cansancio) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene cansancio mas de lo usual? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE PERDIDA DE GUSTO Y OLFATO
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,perdida_gusto_olfato) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene perdida de olfato y gusto? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE DIARREA
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,diarrea) :-
    arreglo_escribir_lista(['¿',Paciente,' ultimamente tiene diarrea? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE DOLOR ABDOMINAL
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,dolor_abdominal) :-
    arreglo_escribir_lista(['¿',Paciente,' tienes dolor abdominal? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE EL SENTIMIENTO DE PESADEZ
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,pesadez) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene una sensacion de pesadez? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE ACIDEZ
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,acidez) :-
    arreglo_escribir_lista(['¿',Paciente,' sientes una sensacion de acides persistente? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE NAUSEAS
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,nauseas) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene nauseas? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE ESTRES
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,estres) :-
    arreglo_escribir_lista(['¿',Paciente,' has pasado por una situacion de mucho estres recientemente? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE VOMITO
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,vomito) :-
    arreglo_escribir_lista(['¿',Paciente,' vomita frecuentemente? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE UN DOLOR EN EL OÍDO
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,dolor_oido) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene un dolor agudo en el oido? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE UN SANGRADO NASAL
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,sangrado_nasal) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene sangrado nasal? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE UN CAMBIO DE VISIÓN
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,cambio_vision) :-
    arreglo_escribir_lista(['¿',Paciente,' tiene cambios en la vision? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE TIENE UNA HEMORRAGIA
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,hemorragia) :-
    arreglo_escribir_lista(['¿',Paciente,' recientemete has tenido alguna hemorragia? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% VALIDACIÓN PARA SABER SI EL PACIENTE COME O NO
% ----------------------------------------------------------------------
sintoma_enfermedad_pregunta(Paciente,no_comer) :-
    arreglo_escribir_lista(['¿',Paciente,' te cuesta comer? (s/n)']),
    respuesta(Opcion),
    Opcion='s'.

% ----------------------------------------------------------------------
% REQUISITOS PARA UNA INFECCIÓN DE TRANSMISIÓN SEXUAL
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'una infeccion de transmision sexual') :-
    sintoma_enfermedad_pregunta(Paciente,ardor_orinar),
    sintoma_enfermedad_pregunta(Paciente,fiebre),
    sintoma_enfermedad_pregunta(Paciente,dolor_coito),
    sintoma_enfermedad_pregunta(Paciente,llagas_genitales).

recomendacion_posible_enfermedad_padecible(Paciente,'ve urgentemente a un medico, o bien un ginecologo') :-
    sintoma_enfermedad_pregunta(Paciente,ardor_orinar),
    sintoma_enfermedad_pregunta(Paciente,fiebre),
    sintoma_enfermedad_pregunta(Paciente,dolor_coito),
    sintoma_enfermedad_pregunta(Paciente,llagas_genitales).

% ----------------------------------------------------------------------
% REQUISITOS PARA EL COVID-19
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'COVID-19, deberias hacerte la prueba') :-
    sintoma_enfermedad_pregunta(Paciente,fiebre),
    sintoma_enfermedad_pregunta(Paciente,tos),
    sintoma_enfermedad_pregunta(Paciente,cansancio),
    sintoma_enfermedad_pregunta(Paciente,perdida_gusto_olfato),
    sintoma_enfermedad_pregunta(Paciente,diarrea).

recomendacion_posible_enfermedad_padecible(Paciente,'tienes que ir a tu respectivo centro de salud') :-
    sintoma_enfermedad_pregunta(Paciente,fiebre),
    sintoma_enfermedad_pregunta(Paciente,tos),
    sintoma_enfermedad_pregunta(Paciente,cansancio),
    sintoma_enfermedad_pregunta(Paciente,perdida_gusto_olfato),
    sintoma_enfermedad_pregunta(Paciente,diarrea).

% ----------------------------------------------------------------------
% REQUISITOS PARA UNA GESTRITIS NERVIOSA
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'una posible gastritis nerviosa') :-
    sintoma_enfermedad_pregunta(Paciente,nauseas),
    sintoma_enfermedad_pregunta(Paciente,acidez),
    sintoma_enfermedad_pregunta(Paciente,pesadez),
    sintoma_enfermedad_pregunta(Paciente,dolor_abdominal),
    sintoma_enfermedad_pregunta(Paciente,estres).

recomendacion_posible_enfermedad_padecible(Paciente,'deberias hacerte un lavado intestinal y tratar tu estres') :-
    sintoma_enfermedad_pregunta(Paciente,nauseas),
    sintoma_enfermedad_pregunta(Paciente,acidez),
    sintoma_enfermedad_pregunta(Paciente,pesadez),
    sintoma_enfermedad_pregunta(Paciente,dolor_abdominal),
    sintoma_enfermedad_pregunta(Paciente,estres).

% ----------------------------------------------------------------------
% REQUISITOS PARA UNA GASTRITIS
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'gastritis') :-
    sintoma_enfermedad_pregunta(Paciente, nauseas),
    sintoma_enfermedad_pregunta(Paciente, acidez),
    sintoma_enfermedad_pregunta(Paciente, pesadez),
    sintoma_enfermedad_pregunta(Paciente, dolor_abdominal).

recomendacion_posible_enfermedad_padecible(Paciente,'deberias hacerte un lavado intestinal') :-
    sintoma_enfermedad_pregunta(Paciente, nauseas),
    sintoma_enfermedad_pregunta(Paciente, acidez),
    sintoma_enfermedad_pregunta(Paciente, pesadez),
    sintoma_enfermedad_pregunta(Paciente, dolor_abdominal).

% ----------------------------------------------------------------------
% REQUISITOS PARA UNA GASTROENTENRITIS VIRAL
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'una gastroentenritis viral') :-
    sintoma_enfermedad_pregunta(Paciente,vomito),
    sintoma_enfermedad_pregunta(Paciente,diarrea),
    sintoma_enfermedad_pregunta(Paciente,nauseas).

recomendacion_posible_enfermedad_padecible(Paciente,'deberias ir a urgencias') :-
    sintoma_enfermedad_pregunta(Paciente,vomito),
    sintoma_enfermedad_pregunta(Paciente,diarrea),
    sintoma_enfermedad_pregunta(Paciente,nauseas).

% ----------------------------------------------------------------------
% REQUISITOS PARA UNA INFECCIÓN EN EL OÍDO
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'una infeccion en el oido') :-
    sintoma_enfermedad_pregunta(Paciente,dolor_oido),
    sintoma_enfermedad_pregunta(Paciente,fiebre).

posible_enfermedad_padecible(Paciente,'debes de ir urgentemente a un medico, se puede infectar') :-
    sintoma_enfermedad_pregunta(Paciente,dolor_oido),
    sintoma_enfermedad_pregunta(Paciente,fiebre).

% ----------------------------------------------------------------------
% REQUISITOS
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'hipertension') :-
    sintoma_enfermedad_pregunta(Paciente,sangrado_nasal),
    sintoma_enfermedad_pregunta(Paciente,cambio_vision),
    sintoma_enfermedad_pregunta(Paciente,vomito),
    sintoma_enfermedad_pregunta(Paciente,fiebre).

recomendacion_posible_enfermedad_padecible(Paciente,'deberias tomarte tus medicamenteos respectivos') :-
    sintoma_enfermedad_pregunta(Paciente,sangrado_nasal),
    sintoma_enfermedad_pregunta(Paciente,cambio_vision),
    sintoma_enfermedad_pregunta(Paciente,vomito),
    sintoma_enfermedad_pregunta(Paciente,fiebre).

% ----------------------------------------------------------------------
% REQUISITOS PARA EL CÁNCER
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'sintomas asociados al cancer, hazte examenes') :-
    sintoma_enfermedad_pregunta(Paciente,cansancio),
    sintoma_enfermedad_pregunta(Paciente,tos),
    sintoma_enfermedad_pregunta(Paciente,fiebre),
    sintoma_enfermedad_pregunta(Paciente,hemorragia),
    sintoma_enfermedad_pregunta(Paciente,sudor),
    sintoma_enfermedad_pregunta(Paciente,no_comer).

recomendacion_posible_enfermedad_padecible(Paciente,'debes de operarte lo antes posible') :-
    sintoma_enfermedad_pregunta(Paciente,cansancio),
    sintoma_enfermedad_pregunta(Paciente,tos),
    sintoma_enfermedad_pregunta(Paciente,fiebre),
    sintoma_enfermedad_pregunta(Paciente,hemorragia),
    sintoma_enfermedad_pregunta(Paciente,sudor),
    sintoma_enfermedad_pregunta(Paciente,no_comer).

% ----------------------------------------------------------------------
% REQUISITOS PARA UNA FRACTURA INTERNA
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'una fractura interna, mejor hazte una radiografia') :-
    sintoma_enfermedad_pregunta(Paciente,pesadez),
    sintoma_enfermedad_pregunta(Paciente,sangrado_nasal),
    sintoma_enfermedad_pregunta(Paciente,nauseas).

recomendacion_posible_enfermedad_padecible(Paciente,'tienen que enyesarte urgentemente la cara') :-
    sintoma_enfermedad_pregunta(Paciente,pesadez),
    sintoma_enfermedad_pregunta(Paciente,sangrado_nasal),
    sintoma_enfermedad_pregunta(Paciente,nauseas).

% ----------------------------------------------------------------------
% REQUISITOS PARA UN ALGÚN TIPO DE DEPRESIÓN
% ----------------------------------------------------------------------
posible_enfermedad_padecible(Paciente,'algun tipo de depresion, ve con el psicologo') :-
    sintoma_enfermedad_pregunta(Paciente,no_comer),
    sintoma_enfermedad_pregunta(Paciente,cansancio),
    sintoma_enfermedad_pregunta(Paciente,pesadez).

recomendacion_posible_enfermedad_padecible(Paciente,'debes de ir a un pediatra de ser necesario que el psicologo no funcione') :-
    sintoma_enfermedad_pregunta(Paciente,no_comer),
    sintoma_enfermedad_pregunta(Paciente,cansancio),
    sintoma_enfermedad_pregunta(Paciente,pesadez).


