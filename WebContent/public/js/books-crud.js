    $("#jsGrid").jsGrid({
        width: "100%",
        height: "400px",

        inserting: true,
        editing: true,
        sorting: true,
        paging: true,

        autoload: true,
        controller: {
        	// 自动加载数据时调用
            loadData: function() {
            	console.log('loading data...');
            	return $.ajax('http://localhost:8080/ssm/books/', {method: 'GET'});
            },
            insertItem: $.noop,
            updateItem: $.noop,
            deleteItem: $.noop
        },

        fields: [
            { name: "title", type: "text", width: 150, validate: "required", title: '书名' },
            { name: "author", type: "text", width: 50, title: '作者' },
            { name: "publisher", type: "text", width: 200, title: '出版社' },
            { type: "control" }
        ]
    });
