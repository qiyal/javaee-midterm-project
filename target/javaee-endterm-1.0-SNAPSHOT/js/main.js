const avatarBox = document.querySelector('.avatar-img-box');
const avatarImg = document.querySelector('.profile-img');


avatarBox.addEventListener('click', evt => {
    avatarImg.classList.toggle('stop-animation');
})