<template>
    <v-app>
        <v-app-bar app>
            Egartech
        </v-app-bar>
        <v-content>
            <div>
                Необходимо авторизоваться
                <messages-list :messages="messages" />
            </div>
        </v-content>
    </v-app>

</template>

<script>
    import MessagesList from 'components/messages/MessageList.vue'
    export default {
        components: {
            MessagesList
        },
        data() {
            return {
                messages: frontendData.messages
            }
        }
    }
</script>

<style>
.main-app {
    color: maroon;
}
</style>
    
    