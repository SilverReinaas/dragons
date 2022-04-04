<template>
    <router-link :to="{name: 'GameDetails', params: {gameId: game.gameId}}" class="list-group-item list-group-item-action">
        <div class="d-flex w-100 justify-content-between">
            <h5><i class="fa-solid fa-star"></i> {{game.score}}</h5>
            <h5><i class="fa-solid fa-shoe-prints"></i> {{game.turns}}</h5>
            <h6>{{this.dateTime}}</h6>
        </div>
    </router-link>
</template>

<script>
export default {
    name: "GameResult",
    props: {
        game: Object
    },
    data() {
        return {
            dateTime: String
        }
    },
    created() {
        if(this.game.dateTime){        
            var dt = new Date(this.game.dateTime)
            this.dateTime = dt.toLocaleString()

        }
        else{
            this.dateTime = ""
        }
    }
}
</script>