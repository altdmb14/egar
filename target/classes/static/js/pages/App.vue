<template>
    <v-app>
        <v-toolbar app>
            <v-toolbar-title>Egartech</v-toolbar-title>
            <v-spacer></v-spacer>
        </v-toolbar>
        <v-content>
            <v-container>
                <messages-list :messages="messages" :soaptime="soaptime"/>
            </v-container>
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
                messages: frontendData.messages,
                soaptime: frontendData.soaptime
            }
        }
    }
</script>

<style>
.main-app {
    color: maroon;
}
</style>
    
    