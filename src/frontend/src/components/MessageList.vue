<template>
    <h5>Messages for game id {{gameId}}</h5>
    <table class="table table-bordered table-sm">
        <thead>
            <tr>
                <th>Message</th>
                <th>Probability</th>
                <th>Reward</th>
                <th>Success</th>
            </tr>
        </thead>
        <tbody>
            <tr :class="{ 'table-success': message.success, 'table-danger': !message.success }" :key="message.adId" v-for="message in messages">
                <td>{{message.message}}</td>
                <td>{{message.probability}}</td>
                <td>{{message.reward}}</td>
                <td>{{message.success}}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
export default {
    name: "MessageList",
    props: {
        gameId: String
    },
    data() {
        return{
            messages: Array
        }
    },
    created() {
        this.getMessages()        
    },
    methods: {
        async getMessages()
        {
            const messagesRes = await fetch('/api/game/messages/' + this.gameId)
            this.messages = await messagesRes.json()
        }
    }
}
</script>

<style scoped>
    td:first{
        border-left: 5px solid;
    }
</style>>