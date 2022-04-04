<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Store</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<link rel="stylesheet" href="css/style.css">
<%@ include file="head.jsp"%>
<style type="text/css">
#home {
    background-image: url(img/back.jpg);
    width: 100%;
    height: 100vh;
    background-size: cover;
    background-position: top 60px center;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
}
</style>
</head>

<body>
	<!-- NAVIGATION -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-white py-3 fixed-top">
		<div class="container">
			<img src="img/logo3.png" alt="">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span><i id="bar" class="fas fa-bars"></i></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link active" href="/">Home</a>
					</li>
					</ul>
			</div>
			<a href="login"> <i class="fas fa-user-circle userIcon"></i>
			</a>
		</div>
	</nav>

	<section id="home" >
<!-- 	<img src="img/back.jpg" alt="" style="width:100%;"> -->
		<div class="container">
		
			<h5>NEW ARRAIVALS</h5>
			<h1>
				<span>Best Price</span> This Year
			</h1>
			<p>
				Shoomatic offers your very comfortable time<br>on walking and
				exercises.
			</p>
			<!-- <button>Shop Now</button> -->
		</div>
	</section>


<section id="brand" class="container">
        <div class="row m-0 py-5">
            <img class="img-fluid col-lg-2 col-md-4 col-6" src="img/brand/1.png" alt="">
            <img class="img-fluid col-lg-2 col-md-4 col-6" src="img/brand/2.png" alt="">
            <img class="img-fluid col-lg-2 col-md-4 col-6" src="img/brand/3.png" alt="">
            <img class="img-fluid col-lg-2 col-md-4 col-6" src="img/brand/4.png" alt="">
            <img class="img-fluid col-lg-2 col-md-4 col-6" src="img/brand/5.png" alt="">
            <img class="img-fluid col-lg-2 col-md-4 col-6" src="img/brand/6.png" alt="">
        </div>
    </section>


<section id="new" class="w-100">
        <div class="row p-0 m-0">
            <div class="one col-lg-4 col-md-12 col-12 p-0">
                <img class="img-fluid" src="img/new/1.jpg" alt="">
                <div class="details">
                    <h2>Extreme Rare Sneakers</h2>
                    <!-- <button class="text-uppercase">Shop now</button> -->
                </div>
            </div>
            <div class="one col-lg-4 col-md-12 col-12 p-0">
                <img class="img-fluid" src="img/new/5.jpg" alt="">
                <div class="details">
                    <h2>Awesome Blank Outfit</h2>
                    <!-- <button class="text-uppercase">Shop now</button> -->
                </div>
            </div>
            <div class="one col-lg-4 col-md-12 col-12 p-0">
                <img class="img-fluid" src="img/new/3.jpg" alt="">
                <div class="details">
                    <h2>Sportwear Up To 50% Off</h2>
                    <!-- <button class="text-uppercase">Shop now</button> -->
                </div>
            </div>
        </div>
    </section>


<section id="featured" class="my-5 pb-5">
        <div class="container text-center mt-5 py-5">
            <h3>Our Featured</h3>
            <hr class="mx-auto">
            <p>Here you can check out our new products with fair price on my store.</p>
        </div>
        <div class="row mx-auto container-fluid">
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/featured/1.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">White Sneakers</h5>
                
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/featured/2.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Casual Shoes</h5>
               
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/featured/3.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Nike College Bag</h5>
               
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/featured/4.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Headbands</h5>
               
            </div>
        </div>
    </section>


<section id="clothes" class="my-5">
        <div class="container text-center mt-5 py-5">
            <h3>Dresses & Jumpsuits</h3>
            <hr class="mx-auto">
            <p>Here you can check out our new products with fair price on my store.</p>
        </div>
        <div class="row mx-auto container-fluid">
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/clothes/1.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Women Blazer</h5>
                
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/clothes/2.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Women Top</h5>
               
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/clothes/3.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">T-shirts</h5>
                
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/clothes/17.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Women Jacket</h5>
              
            </div>
        </div>
    </section>

<section id="watches" class="my-5">
        <div class="container text-center mt-5 py-5">
            <h3>Best Watches</h3>
            <hr class="mx-auto">
            <p>Here you can check out our new products with fair price on my store.</p>
        </div>
        <div class="row mx-auto container-fluid">
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/watches/1.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Fossil Grant</h5>
                
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/watches/2.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Titan Analog</h5>
                
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/watches/3.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">Timex Analogue</h5>
               
            </div>
            <div class="product text-center col-lg-3 col-md-4 col-12">
                <img class="img-fluid mb-3" src="img/watches/1.jpg" alt="">
                <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <h5 class="p-name">FastTrack</h5>
                
            </div>
        </div>
    </section>


	<footer class="mt-5 py-5">
		<div class="row container mx-auto pt-5">
			<div class="footer-one col-lg-3 col-md-6 col-12">
				<img src="img/logo3.png" alt="">
				<p class="pt-3">Welcome To HCL Ecom Website.</p>
			</div>
			<div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
				<h5 class="pb-2">Featured</h5>
				<ul class="text-uppercase list-unstyled">
					<li><a href="#">men</a></li>
					<li><a href="#">women</a></li>
					<li><a href="#">boys</a></li>
					<li><a href="#">girls</a></li>
					<li><a href="#">new arrivals</a></li>
					<li><a href="#">shoes</a></li>
					<li><a href="#">clothes</a></li>
				</ul>
			</div>
			<div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
				<h5 class="pb-2">Contact Us</h5>
				<div>
					<h6 class="text-uppercase">Address</h6>
					<p>Gannavaram, VijayawadaS</p>
				</div>
				<div>
					<h6 class="text-uppercase">Phone</h6>
					<p>1800 456 456</p>
				</div>
				<div>
					<h6 class="text-uppercase">Email</h6>
					<p>Ecom@hcl.COM</p>
				</div>
			</div>

			<div class="footer-one col-lg-3 col-md-6 col-12">
				<h5 class="pb-2">Instagram</h5>
				<div class="row">
					<img class="img-fluid w-25 h-100 m-2" src="img/insta/1.jpg" alt="">
					<img class="img-fluid w-25 h-100 m-2" src="img/insta/2.jpg" alt="">
					<img class="img-fluid w-25 h-100 m-2" src="img/insta/3.jpg" alt="">
					<img class="img-fluid w-25 h-100 m-2" src="img/insta/4.jpg" alt="">
					<img class="img-fluid w-25 h-100 m-2" src="img/insta/5.jpg" alt="">
				</div>
			</div>
		</div>

		<div class="copyright mt-5">
			<div class="row container mx-auto">
				<div class="col-lg-3 col-md-6 col-12 mb-4">
					<img src="img/payment.png" alt="">
				</div>
				<div class="col-lg-4 col-md-6 col-12">
					<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
						class="fab fa-twitter"></i></a> <a href="#"><i
						class="fab fa-linkedin-in"></i></a>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>