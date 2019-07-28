<template>
    <div class="log-checkbox flex-row">
        <div class="checkbox-title">{{title}}</div>
        <div class="checkbox-flag">
            <div class="arr" v-on:click="toggle()">{{getState()}}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CheckBox",
        props: {
            title: String
        },
        data() {
            return {
                isOn: true
            }
        },
        methods: {
            toggle() {
                this.isOn = !this.isOn
            },
            getState() {
                return this.isOn ? "Да": "Нет"
            }
        }
    }
</script>

<style scoped>
    .log-checkbox {
        margin-bottom: 16px;
    }

    .checkbox-title {
        line-height: 40px;
    }

    .checkbox-flag {
        flex-grow: 1;
    }

    .log-checkbox .arr {
        background-color: #F2F3F7;
        border-radius: 10px;
        padding: 8px 16px;
        float: right;
    }
</style>