with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
procedure main is

cota_superior : Integer := 0;
cota_inferior : Integer := 100;
contador : Integer := 1;
alternativa : Integer := 0;

begin
    Put("Pensar un número del 1 al 100");
    New_Line(5);
    
   while alternativa /= 3 loop
        
      contador := (cota_superior + cota_inferior) / 2;
      Put("Número que pensó el usuario: " & Integer'Image(contador));
      New_Line(1);
      Put("Piense un número");
      New_Line(1);
      Put("¿Es mayor? Presione 1");
      New_Line(1);
      Put("¿Es menor? Presione 2");
      New_Line(1);
      Put("¿Es el número que pensó? Presione 3");
      Get(alternativa);
      
      if alternativa = 1 then
         cota_inferior := contador + 1;
      end if;
      
      if alternativa = 2 then 
         cota_superior := contador + 1;
      
      else

      end if;
        
    end loop;
  end main;
