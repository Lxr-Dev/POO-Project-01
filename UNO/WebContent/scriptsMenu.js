var audio, playbtn,mutebtn;
function initAudioPlayer(){
    audio = new Audio();
    audio.src="/home/haruka/Documents/audioMenu.mp3";
    audio.loop = true;
    audio.play();
    playbtn = document.getElementById("playpausebtn");
    mutebtn = document.getElementById("mutebtn");
    playbtn.addEventListener("click",playPause);
    mutebtn.addEventListener("click",mute);

    function playPause(){
        if(audio.paused){
            audio.play();
            playbtn.style.background = "url(/home/haruka/Documents/playpause.png) no-repeat"
        }else{
            audio.pause();
            playbtn.style.background ="url(/home/haruka/Documents/playpause.png) no-repeat"
        }
    }
    function mute(){
        if (audio.muted){
            audio.muted = false;
            mutebtn.style.background ="url(/home/haruka/Documents/playpause.png) no-repeat"
        }else{
            audio.muted = true;
            mutebtn.style.background ="url(/home/haruka/Documents/mute.png) no-repeat"
        }
    }
}
window.addEventListener("load", initAudioPlayer);
