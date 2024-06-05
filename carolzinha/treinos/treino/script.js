let urlParams = new URLSearchParams(window.location.search);
let myParam = urlParams.get("id");
let currentTraining;
let $header = document.querySelector("header");
const $slidesContainer1 = document.querySelector("#slides-container-1");
const $slidesContainer2 = document.querySelector("#slides-container-2");
const $slidesContainer3 = document.querySelector("#slides-container-3");

fetch("../../../resources/jsons/treino-de-carol.json")
  .then((response) => response.json())
  .then((json) => {
    currentTraining = json[myParam];

    populateTraining();
  });

function populateTraining() {
  $header.innerHTML = `${currentTraining.title} | ${currentTraining.subtitle}`;

  if (currentTraining.mobility.length > 0) {
    currentTraining.mobility.forEach(mobility => {
      $slidesContainer1.insertAdjacentHTML("beforeend", `
        <li class="item mobility-item slide">
          <div class="title">${mobility.title}</div>
          <div class="subtitle">${mobility.subtitle}</div>
          <img class="image" src="${mobility.image}" alt="Imagem da mobilidade">
          <div class="info series">
            <div class="value">${mobility.series}</div>
            <div class="key">séries</div>
          </div>
          <div class="info repetitions">
            <div class="value">${mobility.repetitions}</div>
            <div class="key">repetições por série</div>
          </div>
          <div class="info resting">
            <div class="value">${mobility.load}</div>
            <div class="key">kgs</div>
          </div>
          <div class="info resting">
            <div class="value">${mobility.rest}</div>
            <div class="key">segundos de descanso entre séries</div>
          </div>
        </li>
      `);
    });
  }
  else {
    document.querySelector(".training-item.mobility").style.display = "none";
  }

  if (currentTraining.exercises.length > 0) {
    currentTraining.exercises.forEach(exercises => {
      $slidesContainer2.insertAdjacentHTML("beforeend", `
        <li class="item exercises-item slide">
          <div class="title">${exercises.title}</div>
          <div class="subtitle">${exercises.subtitle}</div>
          <img class="image" src="${exercises.image}" alt="Imagem da mobilidade">
          <div class="info series">
            <div class="value">${exercises.series}</div>
            <div class="key">séries</div>
          </div>
          <div class="info repetitions">
            <div class="value">${exercises.repetitions}</div>
            <div class="key">repetições por série</div>
          </div>
          <div class="info resting">
            <div class="value">${exercises.load}</div>
            <div class="key">kgs</div>
          </div>
          <div class="info resting">
            <div class="value">${exercises.rest}</div>
            <div class="key">segundos de descanso entre séries</div>
          </div>
        </li>
      `);
    });
  }
  else {
    document.querySelector(".training-item.exercises").style.display = "none";
  }

  if (currentTraining.cardio.length > 0) {
    currentTraining.cardio.forEach(cardio => {
      $slidesContainer3.insertAdjacentHTML("beforeend", `
        <li class="item cardio-item slide">
          <div class="title">${cardio.title}</div>
          <div class="subtitle">${cardio.subtitle}</div>
          <img class="image" src="${cardio.image}" alt="Imagem da mobilidade">
          <div class="info series">
            <div class="value">${cardio.series}</div>
            <div class="key">séries</div>
          </div>
          <div class="info repetitions">
            <div class="value">${cardio.repetitions}</div>
            <div class="key">repetições por série</div>
          </div>
          <div class="info resting">
            <div class="value">${cardio.load}</div>
            <div class="key">kgs</div>
          </div>
          <div class="info resting">
            <div class="value">${cardio.rest}</div>
            <div class="key">segundos de descanso entre séries</div>
          </div>
        </li>
      `);
    });
  }
  else {
    document.querySelector(".training-item.cardio").style.display = "none";
  }

  startCarousel();
}