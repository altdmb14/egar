<template>
    <v-layout align-space-around justify-start column>
        <span><b>Время полученное с SOAP веб-сервиса:</b> {{soaptime}}</span>
        <br/>
     <message-form :messages="messages" :messageAttr="message" />
     <message-row v-for="message in messages"
                  :key="message.id"
                  :message="message"
                  :editMessage="editMessage"
                  :deleteMessage="deleteMessage"
                  :messages="messages"
     />
    </v-layout>

</template>

<script>
    import MessageRow from 'components/messages/MessageRow.vue'
    import MessageForm from 'components/messages/MessageForm.vue'

    export default {
        props: ['messages', 'soaptime'],
        components: {
            MessageRow,
            MessageForm
        },
        data() {
            return {
                message: null
            }
        },
        methods: {
        editMessage(message) {
            this.message = message
        },
            deleteMessage(message) {
                this.$resource('/zakaz{/id}').remove({id: message.id}).then(result => {
                    if (result.ok) {
                        this.messages.splice(this.messages.indexOf(message), 1)
                    }
                })
            }
      }
    }
</script>

<style scoped>

</style>
    
    