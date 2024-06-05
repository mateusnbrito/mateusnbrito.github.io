let usersListOfTraining;

fetch("../../resources/jsons/treino-de-carol.json")
  .then((response) => response.json())
  .then((json) => {
    usersListOfTraining = json;

    populateTrainings();
  });

function populateTrainings() {
  console.log(usersListOfTraining);
}