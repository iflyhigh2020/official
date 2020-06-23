<template>
    <div>
        <div class="container">
            <div class="handle-box">
                <!--<el-select v-model="query.activeFlag" placeholder="状态" class="handle-select mr10">
                    <el-option  :value="1">激活1</el-option>
                    <el-option  :value="0">激活2</el-option>
                </el-select>-->
                <el-input v-model="query.title" placeholder="标题" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-table
                    :data="tableData"
                    border
                    class="table"
                    ref="multipleTable"
                    header-cell-class-name="table-header"
            >
                <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                <el-table-column label="图片" align="center">
                    <template slot-scope="scope">
                        <el-image
                                class="table-td-thumb"
                                :src="scope.row.imgUrl"
                                :preview-src-list="[scope.row.imgUrl]"
                        ></el-image>
                    </template>
                </el-table-column>
                <el-table-column prop="title" label="标题"></el-table-column>
                <el-table-column label="状态" align="center">
                    <template slot-scope="scope">
                        <el-tag
                                :type="scope.row.activeFlag===1 ?'success':(scope.row.state===0?'danger':'')"
                        >{{scope.row.activeFlag === 1 ? '激活': '禁用'}}</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="orderNum" label="显示顺序"></el-table-column>
                <el-table-column prop="createTime" :formatter="formatDate" label="添加时间"> </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                                type="text"
                                icon="el-icon-edit"
                                @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                                type="text"
                                icon="el-icon-delete"
                                class="red"
                                @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                        background
                        layout="total, prev, pager, next"
                        :current-page="pageNum"
                        :page-size="pageSize"
                        :total="pageTotal"
                        @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="标题">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="顺序">
                    <el-input v-model="form.orderNum"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="form.content"></el-input>
                </el-form-item>
                <el-form-item label="是否禁用">
                    <el-radio-group v-model="form.activeFlag">
                        <el-radio border :label="1">激活</el-radio>
                        <el-radio border :label="0">禁用</el-radio>
                    </el-radio-group>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<script>
    export default {
        name: 'slidesTable',
        components: {  },
        props: {
            pageType: {
                type: Number
            },
            groupId: {
                type: Number
            }
        },
        data() {
            return {
                query: {
                    activeFlag: '',
                    title: '',
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                pageTotal: 0,
                form: {},
                idx: -1,
                id: -1,
                pageNum: 1,
                pageSize: 5
            };
        },
        created() {
            this.getData(1);
        },
        methods: {
            getData(pageNum) {
                const url = this.commRouter + '/slides/list4Manager';
                const queryCond = this.query;
                queryCond.pageType=this.pageType;
                queryCond.groupId=this.groupId;
                const data= {
                    filters:queryCond,
                    pageNum: pageNum,
                    pageSize: this.pageSize
                };
                this.httpPost(url, data, false, false)
                    .then((response) => {
                        this.tableData = response.data.value.list;
                        this.pageTotal = response.data.value.total;
                    }).catch((error) => {
                    console.log(error)
                });
            },
            // 触发搜索按钮
            handleSearch() {
                this.getData(1);
            },

            // 分页导航
            handlePageChange(pageNum) {
                this.getData(pageNum);
            },
            formatDate(row, column, cellValue){
                let datetime = row.createTime;
                if(datetime){
                    datetime = new Date(datetime);
                    let y = datetime.getFullYear() + '-';
                    let mon = datetime.getMonth()+1 + '-';
                    let d = datetime.getDate();
                    return y + mon + d;
                }
                return ''
            },
            // 编辑操作
            handleEdit(index, row) {
                this.idx = index;
                this.form = row;
                this.editVisible = true;

                this.form.id = row.id;
                this.form.title = row.title;
                this.form.orderNum = row.orderNum;
                this.form.content = row.content;
                this.form.activeFlag = row.activeFlag;

            },
            // 保存编辑
            saveEdit() {

                const url = this.commRouter + '/slides/update';
                const data= this.form;
                this.httpPost(url, data, true, true)
                    .then((response) => {
                        this.editVisible = false;
                        this.$set(this.tableData, this.idx, this.form);
                    }).catch((error) => {
                    console.log(error)
                });
            },

            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('删除后不可恢复，确定吗？', '提示', {
                    type: 'warning'
                })
                    .then(() => {
                        const url = this.commRouter + '/slides/delete?id=' + row.id;
                        this.httpGet(url).then((response) => {
                            this.$message.success('删除成功');
                            this.tableData.splice(index, 1);
                        }).catch((response) => {
                            this.$message.error('操作失败');
                        })
                    })
                    .catch(() => {});
            },
        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .table {
        width: 100%;
        font-size: 14px;
    }
    .red {
        color: #ff0000;
    }
    .mr10 {
        margin-right: 10px;
    }
    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
