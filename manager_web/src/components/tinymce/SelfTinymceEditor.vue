<template>
    <div class="container tinymce-editor" ref="tinymceRef">
        <tinymce-editor
                api-key="API_KEY"
                :init="tinymceConfig"
                v-model="myValue"
                :disabled="disabled"
                @onClick="onClick"
        ></tinymce-editor>
    </div>
</template>

<script>
    import tinymce from 'tinymce/tinymce'
    import Editor from '@tinymce/tinymce-vue'
    import 'tinymce/themes/silver'
    import 'tinymce/themes/mobile'
    // import 'tinymce/themes/silver/theme'

    import 'tinymce/plugins/image'// 插入上传图片插件
    import 'tinymce/plugins/table'// 插入表格插件
    import 'tinymce/plugins/lists'// 列表插件
    import 'tinymce/plugins/wordcount'// 字数统计插件
    import 'tinymce/plugins/link'// 超链接
    import 'tinymce/plugins/preview'// 预览
    import 'tinymce/plugins/hr'// 水平分割线
    import 'tinymce/plugins/media'

    export default {
        name: "SelfTinymceEditor",
        props: {
            value: {
                type: String,
                default: ''
            },
            disabled: {
                type: Boolean,
                default: false
            },
            plugins: {
                type: [String, Array],
                default: 'lists image table wordcount link preview hr media '
            },
            toolbar: {
                type: [String, Array],
                // default: 'undo redo |  formatselect | bold italic forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists image table | removeformat'
                default: `styleselect | fontselect | fontsizeselect | forecolor backcolor | bold italic underline strikethrough | image  media | table | alignleft aligncenter alignright alignjustify | outdent indent | numlist bullist | preview removeformat  hr | paste code  link | undo redo | fullscreen `,

            }
        },
        data() {
            return {
                tinymceConfig : {
                    plugins: this.plugins,
                    toolbar: this.toolbar,
                    // theme: 'modern',
                    language_url: 'tinymce/langs/zh_CN.js',
                    placeholder: '在这里输入文字',
                    skin_url: 'tinymce/skins/ui/oxide',
                    language: 'zh_CN',
                    height: 600,//编辑器高度
                    branding: false,//是否禁用“Powered by TinyMCE”
                    menubar: false,//顶部菜单栏显示
                    paste_word_valid_elements: '*[*]',        // word需要它
                    paste_data_images: true,                  // 允许粘贴图像，粘贴的同时能把内容里的图片自动上传，非常强力的功能
                    paste_convert_word_fake_lists: false,     // 插入word文档需要该属性
                    paste_webkit_styles: 'all',
                    paste_merge_formats: true,
                    nonbreaking_force_tab: false,
                    paste_auto_cleanup_on_paste: false,
                    style_formats: [
                        {
                            title: '首行缩进',
                            block: 'p',
                            styles: { 'text-indent': '2em' }
                        },
                        {
                            title: '行高',
                            items: [
                                {title: '1', styles: { 'line-height': '1' }, inline: 'span'},
                                {title: '1.5', styles: { 'line-height': '1.5' }, inline: 'span'},
                                {title: '2', styles: { 'line-height': '2' }, inline: 'span'},
                                {title: '2.5', styles: { 'line-height': '2.5' }, inline: 'span'},
                                {title: '3', styles: { 'line-height': '3' }, inline: 'span'}
                            ]
                        }
                    ],
                    forced_root_block: 'p',
                    force_p_newlines: true,
                    importcss_append: true,
                    content_style: `
                        *                         { padding:0; margin:0; }
                        html, body                { height:100%; }
                        img                       { max-width:100%; display:block;height:auto; }
                        a                         { text-decoration: none; }
                        iframe                    { width: 100%; }
                        p                         { line-height:1.6; margin: 0px; }
                        table                     { word-wrap:break-word; word-break:break-all; max-width:100%; border:none; border-color:#999; }
                        .mce-object-iframe        { width:100%; box-sizing:border-box; margin:0; padding:0; }
                        ul,ol                     { list-style-position:inside; }
                      `,
                    font_formats: `
                        微软雅黑=微软雅黑;
                        宋体=宋体;
                        黑体=黑体;
                        仿宋=仿宋;
                        楷体=楷体;
                        隶书=隶书;
                        幼圆=幼圆;
                        Andale Mono=andale mono,times;
                        Arial=arial, helvetica,
                        sans-serif;
                        Arial Black=arial black, avant garde;
                        Book Antiqua=book antiqua,palatino;
                        Comic Sans MS=comic sans ms,sans-serif;
                        Courier New=courier new,courier;
                        Georgia=georgia,palatino;
                        Helvetica=helvetica;
                        Impact=impact,chicago;
                        Symbol=symbol;
                        Tahoma=tahoma,arial,helvetica,sans-serif;
                        Terminal=terminal,monaco;
                        Times New Roman=times new roman,times;
                        Trebuchet MS=trebuchet ms,geneva;
                        Verdana=verdana,geneva;
                        Webdings=webdings;
                        Wingdings=wingdings,zapf dingbats`,
                    // Image
                    imagetools_toolbar: 'rotateleft rotateright | flipv fliph | editimage imageoptions',
                    // Tab
                    tabfocus_elements: ':prev,:next',
                    object_resizing: true,
                    images_upload_handler: (blobInfo, success, failure) => {

                        if (blobInfo.blob().size > 1048576) {
                            failure('文件体积过大')
                        }

                        // 发送到后台，传送到阿里云oss，返回上传后的网络地址
                        const uploadImgUrl =this.commRouter + "/img/imgUpload";
                        var xhr, formData;
                        xhr = new XMLHttpRequest();
                        xhr.withCredentials = false;
                        xhr.open('POST', uploadImgUrl);
                        formData = new FormData();
                        formData.append('file', blobInfo.blob());
                        xhr.onload = function() {
                            if (xhr.status != 200) {
                                failure('HTTP Error: ' + xhr.status);
                                return;
                            }
                            const result = JSON.parse(this.responseText);
                            if (!result || typeof result.value != 'string') {
                                failure('Invalid JSON: ' + xhr.responseText);
                                return;
                            }
                            success(result.value);
                        }
                        xhr.send(formData);
                    }
                },
                myValue: this.value
            }
        },
        mounted() {
            tinymce.init({});
        },
        methods: {
            // 添加相关的事件，可用的事件参照文档=> https://github.com/tinymce/tinymce-vue => All available events
            // 需要什么事件可以自己增加
            onClick (e) {
                this.$emit('onClick', e, tinymce)
            },
            // 可以添加一些自己的自定义事件，如清空内容
            clear () {
                this.myValue = ''
            },
            getContent() {
               return tinymce.activeEditor.getContent();
            }
        },
        watch: {
            value (newValue) {
                this.myValue = newValue
            },
            myValue (newValue) {
                this.$emit('input', newValue)
            }
        },
        components: {
            'tinymce-editor': Editor
        }
    }
</script>

<style scoped>

</style>