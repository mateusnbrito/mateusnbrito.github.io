let $listOfTrainings = document.querySelector("#list-of-trainings");
let usersListOfTraining;

fetch("../../resources/jsons/treino-de-carol.json")
  .then((response) => response.json())
  .then((json) => {
    usersListOfTraining = json;

    populateTrainings();
  });

function populateTrainings() {
  usersListOfTraining.forEach(training => {
    $listOfTrainings.insertAdjacentHTML("beforeend", `<li class="list-item"><a href="/carolzinha/treinos/treino/?id=${training.id}">${training.title}</a></li>`);
  });
}