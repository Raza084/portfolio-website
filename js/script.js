window.onload = function () {
  /* ================= TYPEWRITER EFFECT ================= */
  const words = [
    "Web Developer",
    "Frontend Developer",
    "Java Developer",
    "Full Stack Learner",
  ];

  let wordIndex = 0;
  let charIndex = 0;
  let currentText = "";
  let isDeleting = false;

  const textElement = document.getElementById("changing-text");

  function typeEffect() {
    const currentWord = words[wordIndex];

    if (isDeleting) {
      currentText = currentWord.substring(0, charIndex--);
    } else {
      currentText = currentWord.substring(0, charIndex++);
    }

    textElement.innerText = currentText;

    let speed = isDeleting ? 50 : 100;

    if (!isDeleting && charIndex === currentWord.length + 1) {
      isDeleting = true;
      speed = 1000; // pause before deleting
    } else if (isDeleting && charIndex === 0) {
      isDeleting = false;
      wordIndex = (wordIndex + 1) % words.length;
      speed = 300; // pause before typing next word
    }

    setTimeout(typeEffect, speed);
  }

  typeEffect();

  /* ================= PROJECT MODAL ================= */
  const images = document.querySelectorAll(".project-img");
  const modal = document.getElementById("project-modal");
  const modalImg = document.getElementById("modal-img");
  const modalTitle = document.getElementById("modal-title");
  const modalDesc = document.getElementById("modal-desc");
  const modalLink = document.getElementById("modal-link");
  const closeBtn = document.querySelector(".close-btn");

  images.forEach((img) => {
    img.addEventListener("click", () => {
      modal.style.display = "flex";

      modalImg.src = img.src;
      modalTitle.innerText = img.dataset.title;

      /* allow multiline + richer details */
      if (img.dataset.desc) {
        modalDesc.innerHTML = img.dataset.desc.replace(/\\n/g, "<br>");
      } else {
        modalDesc.innerText = "";
      }

      modalLink.href = img.dataset.link || "#";
    });
  });

  /* ================= MODAL CLOSE ================= */
  closeBtn.addEventListener("click", () => {
    modal.style.display = "none";
  });

  modal.addEventListener("click", (e) => {
    if (e.target === modal) {
      modal.style.display = "none";
    }
  });
  const form = document.querySelector(".contact-form");
  const successMsg = document.getElementById("success-msg");

  if (form) {
    form.addEventListener("submit", async (e) => {
      e.preventDefault();

      const formData = new FormData(form);

      try {
        await fetch(form.action, {
          method: "POST",
          body: formData,
          headers: {
            Accept: "application/json",
          },
        });

        successMsg.style.display = "block";
        form.reset();

        setTimeout(() => {
          successMsg.style.display = "none";
        }, 3000);
      } catch (error) {
        alert("Error sending message");
      }
    });
  }
};
