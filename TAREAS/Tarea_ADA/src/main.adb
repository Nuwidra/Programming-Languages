with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
procedure main is

cota_superior : Integer := 0;
cota_inferior : Integer := 100;
contador : Integer := 1;
alternativa : Integer := 0;

begin
    Put("Pensar un n�mero del 1 al 100");
    New_Line(2);


   while alternativa /= 3 loop

      contador := (cota_superior + cota_inferior) / 2;
      Put("Piense un n�mero");
      New_Line(1);
      Put("N�mero que pens�: " & Integer'Image(contador));
      New_Line(1);
      Put("�El numero que pens� es menor? Entonces presione 1");
      New_Line(1);
      Put("�El numero que pens� es mayor? Entonces presione 2");
      New_Line(1);
      Put("�Este es el n�mero en el que pens�? Entonces presione 3");
      New_Line(1);
      Get(alternativa);

      if alternativa = 1 then
         cota_inferior := contador + 1;
      end if;

      if alternativa = 2 then
         cota_superior := contador + 1;

      else

         null;
      end if;

    end loop;
  end main;
