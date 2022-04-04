<template>
    <div class="d-flex w-100 justify-content-center">
        <div class="list-group col-lg-6 col-md-8 col-12" >
            <GameResult :key="game.gameId" v-for="game in gameList" :game="game"/>
        </div>
    </div>
</template>
<script>
import GameResult from './GameResult.vue'

export default {
    name: 'GameList',
    props: {
        gameList: Array
    },
    components: {
        GameResult
    },
    methods: {
    }
}
</script>

<style scoped>
</style>