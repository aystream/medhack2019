<template>
    <div class="call-component">
        <div class="layout">
            <div class="call flex-col">
                <div class="call-name"></div>
                <div class="call-video">
                    <iframe :src="'https://appr.tc/r/' + roomId" width=816px height=400px
                            allow="geolocation; microphone; camera" scrolling="no">
                        <p>Your browser does not support iframes.</p>
                    </iframe>
                </div>
                <div class="panel-bottom">
                    <img class="callend" src="/callend.png" v-on:click="goBack">
                    <img class="mute" src="/mute.png">
                    <img class="speaker" src="/speaker.svg">
                </div>
            </div>
            <div class="log">
                <div class="log-name">{{model.name}}</div>
                <div class="log-address">{{model.address}}</div>
                <div class="log-address-comment">{{model.addressComment}}</div>
                <div class="log-1-buttons">
                    <a class="btn btn-white">История обращений</a>
                    <a class="btn">Медицинская карта</a>
                </div>
                <div class="log-diagnose">{{model.diagnose}}</div>
                <div class="log-simptoms"><b>Симптомы:&nbsp;</b>{{model.simptoms}}</div>
                <div class="log-results">Результаты первичного осмотра<a class="btn">Выгрузить</a></div>
                <div class="log-results-date">{{model.resultsDtae}}</div>
                <div class="log-second">Вторичный осмотр</div>
                <div class="log-second-date">{{model.secondDate}}</div>
                <div class="log-checkboxes flex-col">
                    <check-box v-for="box in checkboxes" v-bind:title="box"></check-box>
                </div>
                <div class="log-comments">
                    <textarea cols="80" rows="4" placeholder="Допольнительные комментарии"></textarea>
                </div>
                <div class="log-2-buttons">
                    <a class="btn">Запись на выписку</a>
                    <a class="btn">Повторная консультация</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import CheckBox from "./CheckBox";

    export default {
        name: "CallWindow",
        components: {CheckBox},


        created() {
            this.roomId = this.$route.query.roomId;
            console.log(this.$route.query);
            if (this.roomId === undefined || this.roomId == null) {
                this.roomId = "5453454353";
            }
            this.getCard()
        },
        data() {
            return {
                model: {
                    name: "Городецкий Андрей Валерьевич",
                    address: "Поликлиника 1, г. Москва",
                    addressComment: "2 участок общей практики",
                    diagnose: "Катаральная ангина",
                    simptoms: "Высокая температура тела, умереннная реакиця регионарных лимфатических узлов, отечность небных дужек, гиперимия миндалин",
                    results: "",
                    resultsDtae: "24 июля 2019, 12:30",
                    second: "",
                    secondDate: "1 августа 2019, 12:30",
                    checkboxes: []


                },
                roomId: "med123455",
                currentMessage: "",
                notes: [],
                checkboxes: ["Озноб", "Ощущение першения в горле", "Головная боль", "Боли в суставах"]
            }
        },
        methods: {
            goBack() {
                this.$router.push('/')
            },
            addNote() {
                let newNote = {
                    createDate: new Date(),
                    text: this.currentMessage,
                };
                this.notes.push(newNote)
                this.currentMessage = ""
            },

            getCard() {
                axios.get('api/consultations')
                    .then(({data}) => {
                        this.model = data
                    })
                    .catch(e => {
                        this.errors.push(e)
                    })
            }

        },

    }
</script>

<style scoped>

    .btn {
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

    .call-video {
        text-align: left;
        width: 816px;
        margin-top: 88px;
    }

    .layout {
        display: flex;
    }

    .log {
        padding: 20px;
    }

    .notes {
        list-style: none;
    }

    .doctor-note {
        text-align: left;
        margin: 0px;
        padding: 10px;
        font-weight: bold;
    }

    .note-date {
        color: #ccc;

    }

    .flex-row {
        display: flex;
        flex-direction: row;
    }

    .flex-col {
        display: flex;
        flex-direction: column;
    }

    .panel-bottom {
        background-color: #202D3D;
        height: 118px;
        text-align: left;
    }

    .callend, .mute, .speaker {
        margin-left: 40px;
        cursor: pointer;
        line-height: 118px;
        vertical-align: middle;
    }

    .log {
        text-align: left;
        width: 1112px;
    }

    .log-name {
        color: #000;
        font-size: 36px;
        font-family: 'Roboto', sans-serif;
        font-weight: bold;
        margin-bottom: 20px;
    }


    .log-1-buttons {
        margin-top: 16px;
        margin-bottom: 28px;
    }

    .log-address, .log-address-comment {
        color: #6E7782;
        font-size: 16px;
    }

    .log-diagnose {
        font-size: 25px;
        font-weight: bold;
    }

    .log-simptoms {
        color: #6E7782;
        font-size: 16px;
        margin-bottom: 16px;
    }

    .log-simptoms b {
        color: black;
    }

    .log-results {
        color: #000;
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 16px;
    }

    .log-results .btn {
        margin-left: 16px;
    }

    .log-results-date {
        margin-bottom: 16px;
        margin-top: -16px;
    }

    .log-second {
        color: #000;
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 16px;
    }

    .log-second-date {
        margin-bottom: 16px;
        margin-top: -16px;
    }

    .log-checkboxes {
        margin-bottom: 16px;
        width: 518px;
    }

    .log-comments textarea {
        margin-top: 16px;
        border: none;
        color: #6E7782;
        background-color: #F2F3F7;
        border-radius: 10px;
        padding: 10px;
    }

    .log-2-buttons {
        margin-top: 16px;
    }

</style>