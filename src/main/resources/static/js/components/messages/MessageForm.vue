<template>
    <v-layout row>
        <v-text-field
                label="Имя заказчика"
                placeholder="Пишем имя заказчика"
                v-model="name"
        />
        <v-text-field
                label="Адрес"
                placeholder="Пишем адрес заказа"
                v-model="address"
        />
        <v-text-field
                label="Сумма"
                placeholder="Введите сумму заказа"
                v-model="summary"
        />
        <v-btn @click="save">
            Сохранить
        </v-btn>

        <v-btn @click="refresh">
            Обновить данные по товарам
        </v-btn>
    </v-layout>
</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++) {
            if (list[i].id === id) {
                return i;
            }
        }
        return -1
    }
    export default {
        props: ['messages', "messageAttr"],
        data() {
            return {
                name:'',
                address:'',
                summary:'',
                id:''
            }
        },
        watch: {
            messageAttr: function(newVal, oldVal) {
                this.name = newVal.name
                this.address = newVal.address
                this.summary = newVal.summary
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                const message = { name: this.name, address: this.address, summary: this.summary};

                if(this.id) {
                    this.$resource('/zakaz{/id}').update({id : this.id}, message).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.messages, data.id)
                            this.messages.splice(index, 1, data)
                            this.name = ''
                            this.address = ''
                            this.summary = ''
                            this.id = ''
                        })
                    )
                } else {
                    this.$resource('/zakaz').save({}, message).then(result =>
                        result.json().then(data => {
                            this.messages.push(data)
                            this.name = ''
                            this.address = ''
                            this.summary = ''
                        })
                    )
                }
            },
            refresh() {
                this.$resource('/zakaz/refresh').save({})
            }
        }

    }
</script>

<style scoped>

</style>
    
    