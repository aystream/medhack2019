<template>
    <div class="schedule"><!-- Расписание для врача -->
        <h1>Расписание консультаций</h1>
        <h2 class="schedule-title">Сегодня</h2>
        <ul class="card-list">
            <li class="card" v-for="card, key in cards">
                <!-- Карточка приёма -->
                <div class="flex-row">
                    <div class="card-icon">{{card.name | firstLetter}} {{card.name | secondLetter}}</div>
                    <div class="flex-col card-titles">
                        <div class="card-name">{{card.name}}</div>
                        <div class="card-status">Стутс: {{card.status}}</div>
                        <div class="card-diagnose">Диагноз: {{card.diagnose}}</div>
                    </div>
                    <div class="card-buttons">
                        <a class="card-button btn-white" >Перенести</a>
                        <a class="card-button" v-on:click="call()">Приём</a>
                    </div>
                </div>
                <div class="card-panel--bottom flex-row">
                    <div class="card-panel-icon icon-medcard">Симптомы</div>
                    <div class="card-panel-icon icon-analize">Анализы</div>
                    <div class="card-panel-icon icon-naznacheniya" alt="Назначения">Лечение</div>
                </div>
            </li>
        </ul>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "Schedule",
        data() {
            return {
                cards: [],
                errors: []
            }
        },
        created() {
            this.getCardsDemo()
        },
        methods: {
            getCardsDemo() {
                this.cards = [
                    {
                        id: "1",
                        name:"Лупул Андрей",
                        status: "Вторичный",
                        diagnose: "Остро расператорная ангина",
                        date: "12.10.2019"
                    },
                    {
                        id: "2",
                        name:"Сказочный",
                        status: "Вторичный",
                        diagnose: "Болен",
                        date: "11.10.2019"
                    },
                    {
                        id: "3",
                        name:"Сказочный",
                        status: "Вторичный",
                        diagnose: "Болен",
                        date: "11.10.2019"
                    },
                    {
                        id: "4",
                        name:"Сказочный",
                        status: "Вторичный",
                        diagnose: "Болен",
                        date: "11.10.2019"
                    },
                    {
                        id: "5",
                        name:"Сказочный",
                        status: "Вторичный",
                        diagnose: "Болен",
                        date: "11.10.2019"
                    },
                ];
            },
            getCards() {
                axios.get('/api/cards')
                    .then(({ data }) => {
                        this.items = data.messages
                    })
                    .catch(e => {
                        this.errors.push(e)
                    })
            },
            call() {
                this.$router.push('/call')
            }
        }

    }
</script>

<style scoped>
    a {
        cursor: pointer;
    }

    .schedule-title {
        text-align: left;
        padding-left: 40px;
    }

    .card-list {
        list-style: none;
    }

    .card {
        border-radius: 5px;
        font-size: 18px;
        text-align: left;
        margin-bottom: 50px;
        margin-right: 40px;
        /*border: 1px dotted #333;*/
        box-shadow: 0 2px 12px #ccc;
        padding: 20px;
        height: 110px;
    }

    .card-icon {
        border-radius: 25px;
        background-color: #4EB9FA;
        color: white;
        width: 50px;
        height: 50px;
        text-align: center;
        vertical-align: middle;
        line-height: 50px;
        margin-right: 20px;
    }

    .card-titles {
        width: 600px;
    }

    .card-name {
        font-weight: bold;
        font-size: 20px;
    }

    .card-status, .card-diagnose {
        color: #aaa;
        font-size: 14px;
    }


    .card-buttons {
        margin-top: 20px;
        width: 400px;
        text-align: right;

        flex-grow: 1;
    }

    .card-button {
        width: 300px;
        height: 40px;
        font-weight: bold;
        color: white;
        background-color: blueviolet;
        padding: 10px;
        margin-right: 20px;
        background-color: #4EB9FA;
        border-radius: 20px;
        padding-left: 30px;
        padding-right: 30px;
    }

    .btn-white {
        background-color: #FFF !important;
        color: #4EB9FA;
        border: 1px solid #4EB9FA;
    }

    .flex-row {
        display: flex;
        flex-direction: row;
    }

    .flex-col {
        display: flex;
        flex-direction: column;
    }

    .card-panel--bottom {
        margin-top: 10px;
        margin-left: 70px;
    }

    .card-panel-icon {
        font-size: 14px;
        color: white;
        border-radius: 25px;
        background-color: #6FCF97;
        padding: 0px 20px;
        margin-right: 16px;
        height: 32px;
        line-height: 32px;
        cursor: pointer;
    }



</style>