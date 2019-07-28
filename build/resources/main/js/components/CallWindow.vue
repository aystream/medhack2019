<template>
    <div class="call-component">
        <div class="layout" >
            <div class="call flex-col">
                <div class="call-name"></div>
                <div class="call-video">
                    <iframe src="https://appr.tc/r/31337" width=816px height=400px allow="geolocation; microphone; camera" scrolling="no">
                        <p>Your browser does not support iframes.</p>
                    </iframe>
                </div>
                <div class="panel-bottom">
                    <img class="callend" src="/callend.png" v-on:click="goBack">
                </div>
            </div>
            <div class="log">
                <div class="log-name">Городецкий Андрей Валерьевич</div>
                <div class="log-address">Поликлиника 1, г. Москва</div>
                <div class="log-address-comment">2 участок общей практики</div>
                <div class="log-1-buttons" >
                    <a class="btn btn-white">История обращений</a>
                    <a class="btn">Медицинская карта</a>
                </div>
                <div class="log-diagnose">Катаральная ангина</div>
                <div class="log-simptoms"><b>Симптомы:&nbsp;</b>Высокая температура тела, умереннная реакиця регионарных лимфатических узлов, отечность небных дужек, гиперимия миндалин</div>
                <div class="log-results">Результаты первичного осмотра<a class="btn">Выгрузить</a></div>
                <div class="log-results-date">24 июля 2019, 12:30</div>
                <div class="log-second">Вторичный осмотр</div>
                <div class="log-second-date">1 августа 2019, 12:30</div>
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
<!--                <textarea class="call-note" cols="40" rows="3" v-on:keyup.enter="addNote" v-model="currentMessage">-->
<!--                </textarea>-->
<!--                <ul class="notes" >-->
<!--                    <li class="doctor-note" v-for="note in notes.slice().reverse()" >-->
<!--                        <div class="note-date">{{note.createDate.getHours()}}:{{note.createDate.getMinutes()}}</div>-->
<!--                        <div class="note-text">{{note.text}}</div>-->
<!--                    </li>-->
<!--                </ul>-->
            </div>
        </div>
    <!-- Begin Fresh Tilled Soil Video Chat Embed Code -->
    <!--    <div id="freshtilledsoil_embed_widget" class="video-chat-widget"></div>-->
    <!--    <script id="fts" src="http://freshtilledsoil.com/embed/webrtc-v5.js?r=FTS0316-CZ6NqG97"></script>-->
    <!-- End Fresh Tilled Soil Video Chat Embed Code -->
    </div>
</template>

<script>
    import CheckBox from "./CheckBox";

    export default {
        name: "CallWindow",
        components: {CheckBox},
        data() {
            return {
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
                } ;
                this.notes.push(newNote)
                this.currentMessage = ""
            },

        }
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
        margin-top: 66px;
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

    .callend {
        margin-left: 40px;
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
    }


    .log-1-buttons { margin-top: 16px; margin-bottom: 28px; }

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
    }

    .log-second {
        color: #000;
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 16px;
    }

    .log-second-date {
        margin-bottom: 16px;
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