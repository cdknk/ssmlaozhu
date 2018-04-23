    var books = [
       {id: 1, title: 'b1', author: 'a1', publisher: 'p1'},
       {id: 2, title: 'b2', author: 'a2', publisher: 'p2'}
    ];

    $("#jsGrid").jsGrid({
        width: "100%",
        height: "400px",

        inserting: true,
        editing: true,
        sorting: true,
        paging: true,

        data: books,

        fields: [
            { name: "title", type: "text", width: 150, validate: "required", title: '书名' },
            { name: "author", type: "text", width: 50, title: '作者' },
            { name: "publisher", type: "text", width: 200, title: '出版社' },
            { type: "control" }
        ]
    });
