import React, { useState, useEffect } from 'react';

function AudioPlayer() {
  const [audioFiles, setAudioFiles] = useState([]);
  const [selectedAudio, setSelectedAudio] = useState(null);
  const [interval, setInterval] = useState();
  const [totalTimes, setTotalTimes] = useState();
  useEffect(() => {
    // Use require.context to fetch all MP3 files from the "sounds" folder.
    const context = require.context('./sounds', false, /\.mp3$/);
    const audioFilesList = context.keys().map(context);

    setAudioFiles(audioFilesList);
  }, []);

  const playRandomAudio = () => {
    const randomIndex = Math.floor(Math.random() * audioFiles.length);
    const randomAudio = audioFiles[randomIndex];

    const audioElement = new Audio(randomAudio);
    audioElement.play();

    setSelectedAudio(randomAudio);
  };

  const PlaySoundsWithInterval = () => {
      playRandomAudio();
    
      setTimeout(PlaySoundsWithInterval, interval*1000);

  }

  return (
    <div>
      <h1>Audio Player</h1>
      <button onClick={playRandomAudio}>Play Random Sound</button>
      <br />
      <button onClick={PlaySoundsWithInterval}>Funny</button>
      <br />
      <input type="number" placeholder='Seconds Between Sound' value={interval} />
      <input type="number" placeholder='Amount of Sounds in total' value={totalTimes} />

    </div>
  );
}

export default AudioPlayer;
