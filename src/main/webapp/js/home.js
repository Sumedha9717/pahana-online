document.addEventListener('DOMContentLoaded', function() {
    // Hero content animation
    const heroContent = document.querySelector('.hero-content');
    if (heroContent) {
        heroContent.style.opacity = '0';
        heroContent.style.transform = 'translateX(-20px)';
        heroContent.style.transition = 'opacity 0.8s ease, transform 0.8s ease';

        setTimeout(() => {
            heroContent.style.opacity = '1';
            heroContent.style.transform = 'translateX(0)';
        }, 300);
    }

    // Image animation
    const heroImage = document.querySelector('.hero-image img');
    if (heroImage) {
        heroImage.style.opacity = '0';
        heroImage.style.transform = 'translateX(20px)';
        heroImage.style.transition = 'opacity 0.8s ease 0.2s, transform 0.8s ease 0.2s';

        setTimeout(() => {
            heroImage.style.opacity = '1';
            heroImage.style.transform = 'translateX(0)';
        }, 500);
    }

    // Make top bar sticky on scroll
    const topBar = document.querySelector('.top-bar');
    if (topBar) {
        window.addEventListener('scroll', function() {
            if (window.scrollY > 50) {
                topBar.style.boxShadow = '0 2px 15px rgba(0, 0, 0, 0.1)';
                topBar.style.padding = '0.5rem 0';
                document.querySelector('.bookstore-name h1').style.fontSize = '1.2rem';
            } else {
                topBar.style.boxShadow = '0 2px 10px rgba(0, 0, 0, 0.05)';
                topBar.style.padding = '0.8rem 0';
                document.querySelector('.bookstore-name h1').style.fontSize = '1.5rem';
            }
        });
    }
});