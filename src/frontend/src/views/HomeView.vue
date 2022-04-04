<template>    
    <button class="btn btn-primary btn-lg" @click="playGame()">Play</button>    
    <GameList v-if="gamesRendered" class="mt-3" :gameList="games"/>
    <LoadingScreen v-if="loadingSpinner" /> 
</template>

<script>
import GameList from '../components/GameList.vue'
import LoadingScreen from '../components/LoadingScreen.vue'

export default {
  name: "HomeView",
  components: {
    GameList,
    LoadingScreen,
  },
  data() {
    return{
      gamesRendered: Boolean,
      games: Array,
      loadingSpinner: Boolean,
      showGameId: String
    }
  },
  async created() {
    this.gamesRendered = false
    this.loadingSpinner = false
    await this.getGames()
  },
  methods:{
    showGameDetails(gameId)
    {
      console.log(gameId)
    },

    async getGames(){
      const res = await fetch('/api/game/all')
      const gameResults = await res.json()
      this.games = gameResults
      this.gamesRendered = true
    },

    async playGame(){
      this.loadingSpinner = true

      //play the game
      const res = await fetch('/api/game/play')
      const gamePlay = await res.json()

      //save the game to db
      const saveGameRequest = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(gamePlay.gameResult)
      }
      await fetch('/api/game/', saveGameRequest)

      //save game messages to db
      const saveMessagesRequest = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(gamePlay.messageResults)
      }
      await fetch('/api/game/messages/' + gamePlay.gameId, saveMessagesRequest)

      //add game to UI
      const gameResult = gamePlay.gameResult
      this.games = [gameResult, ...this.games]

      this.loadingSpinner = false
    }
  },  
};
</script>