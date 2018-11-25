<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="subjectManage" class="container">
    <div class="row">
        <div class="col-12">
            <subjects v-bind:subject="subjectRoot"></subjects>
        </div>
    </div>

</div>

<script>
    var subjectManage = new Vue({
        el: "#subjectManage",
        data: {
            subjectRoot: '',

        },
        methods: {},
        components: {
            'subjects': {
                name: "subjects",
                props: ['subject'],
                template: "<div v-if='subject!=null'>" +
                        "<div v-if='subject.avaliable==0'>" +
                            "<li>{{subject.name}}&nbsp;&nbsp;&nbsp;" +
                            "<i  @click='addSubject(subject.id)' class='fa fa-plus fa-lg text-success' aria-hidden='true'></i></li>" +
                        "</div>" +
                        "<div v-if='subject.avaliable==1'>" +
                            "<li @click='findPapersBySubjectId(subject.id)'>{{subject.name}}&nbsp;&nbsp;&nbsp;" +
                            "<i @click='deleteSubject(subject.id)' class='fa fa-minus fa-lg text-danger' aria-hidden='true'></i></li>" +
                        "</div>" +
                        "<div v-if='subject.children!=null'>" +
                            "<div v-for='s in subject.children'>" +
                                "<subjects v-bind:subject='s'></subjects>" +
                            "</div>" +
                        "</div>" +
                    "</div>",
                methods: {
                    addSubject: function (id) {
                        alert("add" + id);
                    },
                    deleteSubject: function (id) {
                        alert("delete" + id);
                    },
                    findPapersBySubjectId: function (id) {
                        alert("findPapersBySubjectId" + id);
                    }
                }
            }
        },
        beforeCreate: function () {
            var self = this;
            $.post(
                "${pageContext.request.contextPath}/admin/subject/findAllSubjects",
                function (result, status, xhr) {
                    self.subjectRoot = result;
                }
            );
        }
    });
</script>

