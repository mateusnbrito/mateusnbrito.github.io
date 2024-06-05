function startCarousel() {
  const $slide1 = $slidesContainer1.querySelector(".slide");
  const $slide2 = $slidesContainer2.querySelector(".slide");
  const $slide3 = $slidesContainer3.querySelector(".slide");
  const $prevButton1 = document.querySelector("#slide-arrow-prev-1");
  const $prevButton2 = document.querySelector("#slide-arrow-prev-2");
  const $prevButton3 = document.querySelector("#slide-arrow-prev-3");
  const $nextButton1 = document.querySelector("#slide-arrow-next-1");
  const $nextButton2 = document.querySelector("#slide-arrow-next-2");
  const $nextButton3 = document.querySelector("#slide-arrow-next-3");

  $prevButton1.addEventListener("click", () => {
    const slideWidth = $slide1.clientWidth;
    $slidesContainer1.scrollLeft -= slideWidth;
  });

  $prevButton2.addEventListener("click", () => {
    const slideWidth = $slide2.clientWidth;
    $slidesContainer2.scrollLeft -= slideWidth;
  });

  $prevButton3.addEventListener("click", () => {
    const slideWidth = $slide3.clientWidth;
    $slidesContainer3.scrollLeft -= slideWidth;
  });

  $nextButton1.addEventListener("click", () => {
    const slideWidth = $slide1.clientWidth;
    $slidesContainer1.scrollLeft += slideWidth;
  });

  $nextButton2.addEventListener("click", () => {
    const slideWidth = $slide2.clientWidth;
    $slidesContainer2.scrollLeft += slideWidth;
  });

  $nextButton3.addEventListener("click", () => {
    const slideWidth = $slide3.clientWidth;
    $slidesContainer3.scrollLeft += slideWidth;
  });
}