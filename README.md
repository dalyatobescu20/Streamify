//PROIECT FINAL POO 2022-2023//
//TOBESCU DALYA-ALEXANDRA//


1. IMPLEMENTAREA CLASELOR PRINCIPALE:

        In aceste clase am pus atributele specifice fiecarui tip 
        --> Streamers 
        --> Streams 
        --> User 

2. IMPLEMENATAREA CLASELOR PENTRU LISTE
        
        Am folosit Singleton pentru a putea instantia o singura data fiecare clasa,
        de asemenea si pentru folosirea lor mai usoara in restul claselor.
        -->ListaStreamari
        -->ListaStreams
        -->ListaUseri

3. IMPLEMENTAREA CLASELOR BUILDER
   
        Am folosit Builder pentru fiecare clasa principala pentru a usura adaugarea in 
        liste, fara a mai fi nevoie de constructori, setter and getter in restul codului.
        --> practic am facut codul sa fie mai citibil.

4.IMPLEMENENTAREA CLASELOR COMMANDS
        
        Am folosit Commands atat pentru useri, streamari si pentru clasa Proiect POO
        pentru a evidentia clar fiecare comanda si a separa codul astfel:
        --> ca Streamer poti avea comenzile de adaugare, stergere, listare
        mai exact ComandaAdaugare, ComandaAfisarebyStreamer, ComandaStergere
        --> ca User poti avea ComandaAfisarebyUser, ComandaAscultare, ComandaRecomandari
        ComandaSurpriza
        --> in cazul clasei main am separat fiecare comanda pe care o citesc din fisier,
        astfel main-ul are comenzile lui: add, afisare, clearData(golesc toate listele
        la final), makeLists(fac listele in functie de datele citite din fisier).
        PS: partea asta cu clasa main, am facut-o mai mult ca sa fie mai compact codul.

5.IMPLEMENATAREA CLASEI FATADE
   
        Pentru a evita scrierea codului duplicat in clasele pentru comenzi, am creat o interfata
        Operations si o clasa Fatade, pentru a "ascunde" in acelasi timp codul care se referea 
        la ordonare, conversie, cautare, de restul codului.
        Avand in vedere ca aceste operatii au legatura cu clasa Streams, totul este legat de ea.
    
