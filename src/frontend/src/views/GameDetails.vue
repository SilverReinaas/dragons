<template>
<router-link to="/" class="btn btn-primary btn-lg">Back</router-link>
    <MessageList :gameId="gameId" />
</template>

<script>
import MessageList from '../components/MessageList.vue'

export default {
    name: "GameDetails",
    components: {
        MessageList
    },
    props: {
        gameId: String
    },
    data() {
        return{
        }
    },
    created() {  
    },
    methods: {
    }
}
</script>