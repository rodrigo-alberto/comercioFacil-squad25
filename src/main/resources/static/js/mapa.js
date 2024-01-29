let empreendimentos = [];

const fetchEnterprises = (image) => {
	fetch(image.src)
		.then((response) => response.text())
		.then((response) => {
			const span = document.createElement('span');
			span.innerHTML = response;
			const inlineSVG = span.getElementsByTagName('svg')[0];
			image.parentNode.replaceChild(inlineSVG, image);
			return true;
		})
		.then(() => { getActions() });
}

const highlightedColor = "yellow";
const highlightStoresByCategory = async (categoria) => {
	const empreendimentos = await getEnterprises();

	const enterprises = document.getElementsByClassName('enterprise');
	for (let i = 0; i < enterprises.length; i++) {
		const idEnterprise = enterprises[i].getAttribute('identerprise');
		const lojaCorrespondente = empreendimentos.find(empreendimento => empreendimento.idEnterprise === idEnterprise);
		console.log(lojaCorrespondente)
		if (lojaCorrespondente.mainCategory === categoria) {
			enterprises[i].classList.add('highlighted');
		} else {
			enterprises[i].classList.remove('highlighted');
		}
	}
};


const getActions = () => {

	const radioButtons = document.querySelectorAll('input[type="radio"]');

	radioButtons.forEach(function(radioButton) {
		radioButton.addEventListener('click', async function() {
			await getEnterprises(); 
			const categoriaSelecionada = radioButton.value;
			highlightStoresByCategory(categoriaSelecionada);
		});
	});

	const enterprises = document.getElementsByClassName('enterprise');
	for (let i = 0; i < enterprises.length; i++) {

		enterprises[i].addEventListener('mouseover', function() {
			fillPopover(enterprises[i]);
		});

		enterprises[i].addEventListener('mouseout', function() {
			hidePopover(enterprises[i]);
		})

		enterprises[i].addEventListener('click', function() {
			console.log("Click");
		})
	}
	getEnterprises();
};

const getEnterprises = async () => {

	try {
		const response = await fetch('js/enterprises.json');
		const empreendimentos = await response.json();

		return empreendimentos;


	} catch (error) {
		console.error('Erro ao obter estados:', error);
	}
};


const resetStoreColors = () => {
	const enterprises = document.getElementsByClassName('enterprise');

	for (let i = 0; i < enterprises.length; i++) {
		enterprises[i].style.fill = ""; 
	}
};



const fillPopover = async (enterprise) => {

	const idEnterprise = enterprise.getAttribute('identerprise');
	const empreendimentos = await getEnterprises();
	const numLoja = empreendimentos.find(empreendimento => empreendimento.idEnterprise === idEnterprise);

	const popover = new bootstrap.Popover(enterprise, {
		placement: 'top',
		title: numLoja.fantasyName,
		content: `Descrição: ${numLoja.description}. \n Número da Loja: ${numLoja.numStore} `,
		template: '<div class="popover popover-custom" role="tooltip"><h3 class="popover-header text-white"></h3><div class="popover-body"></div></div>',
	});
	popover.show();
};

const hidePopover = (enterprise) => {
	const popover = bootstrap.Popover.getInstance(enterprise);
	if (popover) {
		popover.hide();
	}
};

function updateImage() {
	var select = document.getElementById("select2");
	var selectedValue = select.options[select.selectedIndex].value;
	var imageContainer = document.getElementById("imageContainer");
	imageContainer.innerHTML = ' <img id="map" src="' + selectedValue + '" alt="Mapa" onload="fetchEnterprises(this)"> ';
};

function updateSelect() {
	var select1 = document.getElementById("select1");
	var select2 = document.getElementById("select2");
	select2.innerHTML = '';

	switch (select1.value) {
		case "opcao1":
			select2.add(new Option("Feiras", "disabled selected hidden"));
			select2.add(new Option("Sacolão Teotonio Vilela", "imgs/map-full.svg"));

			break;
		case "opcao2":
			select2.add(new Option("Feiras", "disabled selected hidden"));
			select2.add(new Option("Mercado da Bahia", "imgs/map-full2.svg"));
			break;
		case "opcao3":
			select2.add(new Option("Feiras", "disabled selected hidden"));
			select2.add(new Option("Feira de Maricá", "imgs/map-full3.svg"));
			break;
		case "opcao4":
			select2.add(new Option("Feiras", "disabled selected hidden"));
			select2.add(new Option("Barracão", "imgs/map-full4.svg"));
			break;
		default:
			break;
	}
};
