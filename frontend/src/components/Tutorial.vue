<template>
  <div>
    <h3>
      Nakon projektovanja projekta u INTELLIJ okruzenje, ako ponudi automatsko instaliranje "npm install" potvrditi, ako ne pozicionirati se u frontend folder projekta u terminalu i kucati sledeće:
      npm install
      npm install vue
      npm install -g @vue/cli
      npm install vuetify
      vue add vuetify
    </h3>
    <p>
      Nakon pokretanja projekta otici na localhost:8080 i time otvarate početnu stranicu nase web aplikacije.
      *****Rukovanje applikacijom:
      -Na početnoj stranici (Home page) sa leve strane vidimo listu svih slikara u bazi.
      -Gore iznad mape možemo videti dugmad za navigaciju kroz delove aplikacije.
      -Klikom na dugme HOME PAGE dolazimo na stranicu na kojoj počinjemo tj na glavnoj stranici aplikacije.
      -Pored HOME PAGE dugmeta imamo dugme TABLE VIEW koje nam otvara deteljniji tabelaran pregled umetničkih dela koji sadrži znatno više informacija od liste na home page-u. Tu možemo da pretražujemo sve informacije o umetničkim delima preko search bara koji prolazi kroz sve sekcije. Takodje možemo da sortiramo dela opadajuće i rastuće po svakoj koloni.
      -Klikom na dugme u koloni show painter, će prikazati informacije o slikaru tog umetničkog dela.
      -Klikom na dugme TUTORIAL dolazite do teksta koji vas vodi kroz funkcionalnosti aplikacije.
      *****Rukovanje slikarima:
      -Kada kliknemo na prvo dugme (olovku) pored imena slikara pristupate funkciji Izmene slikara. Tu možete da izmenite informacije o slikaru.
      -Sledeće dugme pored (kanta) intuitivno briše slikara iz baze.
      -Dugme pored otvara pregled svih informacija o slikaru.
      -Dugmetom na strelicu ka desno, otvara u listi sa desne strane mape, listu svih umetničkih dela tog slikara.
      -Takodje imamo search bar gde možete pretraživati kroz listu bilo koje polje samim kucanjem u search bar.
      -Lista slikara se moze sortirati po bilo kojem atributu iz liste klikom na njen header u opadajućem ili rastućem redosledu.
      -Ispod liste svih slikara imamo veliko dugme Add Painter, u kojoj možete dodati novog slikara u bazu.
      *****Rukovanje umetničkim delima:
      -Kada smo kliknuli na strelicu pored slikara imamo pristup svim njegovim delima.
      -Iznad liste umetničkih dela imamo search bar gde možemo da pretražujemo kroz listu dela. Takodje možemo i da ih sortiramo u opadajućem ili rastućem redosledu klikom na header liste.
      -Kliknom na dugme pored imena u obliku olovke pristupamo izmeni izabranog umetničkog dela. Tu možemo menjati sve informacije o delu.
      -Pored imamo sledeće dugme, dugme za detaljnije informacije o delu. Tu možemo da vidimo informacije kao što su kad je delo nastalo gde je nastalo i sve ostalo sto nas zanima.
      -Pored njega je dugme za brisanje dela koje ga obriše iz baze podataka.
      -Ispod liste umetničkih dela imamo veliko dugme za dodavanje dela u bazu podataka.
    </p>
    <v-btn color="blue " @click="$router.push('/')">Go Back</v-btn>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>