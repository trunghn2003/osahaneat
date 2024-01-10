$(document).ready(function () {
    var token = localStorage.getItem("token");
    let searchParams = new URLSearchParams(window.location.search)
    var linkRestaurant = "http://localhost:8080/restaurant";
    var linkCategory = "http://localhost:8080/category";
    var linkMenu = "http://localhost:8080/menu";
    var resId = searchParams.get('id')
    console.log("Token:", token);
    console.log(resId)


    $.ajax({
        method: "GET",
        url: `${linkRestaurant}/detail?id=${resId}`,
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
        .done(function (msg) {
            if (msg.sucess) {
                console.log(msg)
                var value = msg.data

                var html = `<div >
                    <div class="">
                        <img class="image1 " src="${linkRestaurant}/file/${value.image}" alt="${value.title}">
                        <div class="">
                            <p class="title">${value.title}</p>
                            <p class="subtitle">${value.subtitle}</p>
                            <p class="freeship">Free Shipping: ${value.freeship ? 'Yes' : 'No'}</p>
                            <span> ${value.openDate}</span>
                            <span> ${value.rating}</span>

                        </div>
                    </div>
                    </div>`
                var itemCate = ""
                var itemMenu = ""
                var menuHtml = ""
                $.each(value.listCategoryDTO, function (index, data) {
                    itemCate += `
                <li> <a href = "${data.name_cate}">${data.name_cate} </a></li>
                `
                    menuHtml += `
                    <div id = ${data.name_cate} >  
                    <img class="image1 " src="${linkRestaurant}/file/${data.image}" alt="${data.title}">
                    <div class="">
                        <p class="title">${data.isFreeShip}</p>
                    </div>
                                      
                    </div>
                `
                    $.each(data.listMenuDTO, function (index1, data1) {
                            console.log(data1.image +">>>>")
                            itemMenu += `
                            <a class = "btn-food" data-title = '${data1.title}' data-desc = '${data1.desc}' data-price = '${data1.price}' data-id = '${data1.id}' data-image = '${data1.image}'>
                                <div class="">
                                    <img class="image1"  src="${linkMenu}/file/${data1.image}" alt="${data1.title}">
                                    <div class="">
                                        <p class="title">${data1.image}</p>
                                        <p class="freeship">Free Shipping: ${value.freeship ? 'Yes' : 'No'}</p>
                                    </div>
                                </div>
                            </a>
                        `;
                        
                    })

                })
                var categoryhtml = `
            <ul>
            ${itemCate}
            </ul>
            `
                
                $("#container-detail").append(html);
                $("#container-detail").append(categoryhtml);
                $("#container-detail").append(itemMenu);

                var menuHtml = `<div>

            </div>
            `

            }
        });

        $("body").on("click", ".btn-food", function () {
            console.log("vao nut a")
            // var data = $(this).attr('data');
            console.log($(this).attr('data-image'));
            console.log($(this).attr('data-desc'));
            console.log($(this).attr('data-price'));
            console.log($(this).attr('data-image'));
            var menuID = $(this).attr("data-id")
            var menuPrice = $(this).attr("data-price")
            var menuTitle = $(this).attr("data-title")
            var menuDesc = $(this).attr("data-desc")
            var menuImage = $(this).attr("data-image")
            console.log(menuID + " " + menuImage + " " + menuPrice + " " + menuDesc)




           
        });
        

});
